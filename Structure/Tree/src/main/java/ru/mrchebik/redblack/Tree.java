package ru.mrchebik.redblack;

import java.util.Stack;

/**
 * Created by mrchebik on 15.04.17.
 */
public class Tree {
    private Node root;

    private Node grandDad;
    private Node dad;
    private Node parent;

    private byte nElems = 0;
    private boolean isLeft = false;

    public Tree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            newNode.isRed = false;
        } else {
            boolean isGoAway = false;

            Node current = root;
            dad = root;
            grandDad = dad;
            parent = null;
            while (true) {
                if (dad != root) {
                    grandDad = dad;
                }
                if (parent != null) {
                    dad = parent;
                }
                parent = current;

                if (current.left != null && current.right != null) {
                    if (current.left.isRed && current.right.isRed) {
                        current.left.isRed = false;
                        current.right.isRed = false;

                        if (current != root) {
                            current.isRed = true;
                        }
                    }
                }

                if (data < current.data) {
                    if (!isGoAway) {
                        isLeft = true;
                        isGoAway = true;
                    }
                    current = current.left;
                    if (current == null) {
                        newNode.isRed = true;
                        parent.left = newNode;
                        nElems++;

                        if (nElems > 1) {
                            if (nElems == 2) {
                                check3Elems();
                            } else {
                                if (parent.right != null) {
                                    defaultSet(parent);
                                }

                                bigCheck(newNode);
                            }
                        }

                        return;
                    }
                } else {
                    if (!isGoAway) {
                        isLeft = false;
                        isGoAway = true;
                    }
                    current = current.right;
                    if (current == null) {
                        newNode.isRed = true;
                        parent.right = newNode;
                        nElems++;

                        if (nElems > 1) {
                            if (nElems == 2) {
                                check3Elems();
                            } else {
                                if (parent.left != null) {
                                    defaultSet(parent);
                                }

                                bigCheck(newNode);
                            }
                        }

                        return;
                    }
                }
            }
        }
    }

    private void bigCheck(Node newNode) {
        System.out.println(this);
        System.out.println(grandDad + " // " + dad + " // " + parent + " // " + newNode);
        if (isLeft) {
            if (parent.isRed && newNode.isRed) {
                if (dad.left == parent) {
                    if (parent.left == newNode) {
                        System.out.println(1);
                        LrotateRight(grandDad, dad, parent);
                    } else if (parent.right == newNode) {
                        System.out.println(2);
                        LrotateRight(dad, parent, newNode);
                        System.out.println(this);
                        LrotateRight(grandDad, dad, newNode);
                    }
                } else {
                    if (parent.right == newNode) {
                        System.out.println(3);
                        LrotateLeft(dad, parent, newNode);
                    } else {
                        System.out.println(4);
                        RrotateRight(dad, parent, newNode);
                        System.out.println(this);
                        LrotateRight(grandDad, dad, newNode);
                    }
                }
            } else if (dad.isRed && parent.isRed) {
                if (dad.left == parent) {
                    System.out.println(5);
                    LrotateRightRoot1();
                } else {
                    System.out.println(6);
                    LrotateRight(grandDad, dad, parent);
                    System.out.println(this);
                    LrotateRightRoot1();
                }
            }
        } else {
            if (parent.isRed && newNode.isRed) {
                if (dad.right == parent) {
                    if (parent.right == newNode) {
                        System.out.println(7);
                        RrotateRight(grandDad, dad, parent);
                    } else {
                        System.out.println(8);
                        RrotateRight(dad, parent, newNode);
                        System.out.println(this);
                        RrotateRight(grandDad, dad, newNode);
                    }
                } else {
                    if (parent.left == newNode) {
                        System.out.println(9);
                        RrotateLeft(dad, parent, newNode);
                    } else {
                        System.out.println(10);
                        LrotateRight(dad, parent, newNode);
                        System.out.println(this);
                        RrotateRight(grandDad, dad, newNode);
                    }
                }
            } else if (dad.isRed && parent.isRed) {
                if (dad.right == parent) {
                    System.out.println(11);
                    RrotateRightRoot1();
                } else {
                    System.out.println(12);
                    RrotateRight(grandDad, dad, parent);
                    System.out.println(this);
                    RrotateRightRoot1();
                }
            }
        }
    }

    private void check3Elems() {
        int a = 0, b = 0, c = root.data;
        if (root.left != null && root.right != null) {
            a = root.left.data;
            b = root.right.data;
        } else {
            if (root.left != null) {
                if (root.left.right != null) {
                    b = root.left.right.data;
                }
                if (root.left.left != null) {
                    b = root.left.left.data;
                }
                a = root.left.data;
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    b = root.right.left.data;
                }
                if (root.right.right != null) {
                    b = root.right.right.data;
                }
                a = root.right.data;
            }
        }

        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int mid = a != min && a != max ? a : b != min && b != max ? b : c;

        root = new Node(mid);
        root.left = new Node(min);
        root.right = new Node(max);
    }

    private void LrotateRightRoot1() {
        boolean isRoot = false;
        if (root == grandDad) {
            isRoot = true;
        }

        Node temp = grandDad;

        grandDad = grandDad.left;
        temp.left = grandDad.right;
        grandDad.right = temp;

        if (isRoot) {
            root = grandDad;
        }

        grandDad.isRed = false;
        if (grandDad.left != null) {
            grandDad.left.isRed = false;
        }
    }

    private void LrotateRight(Node grandDad, Node dad, Node parent) {
        grandDad.left = parent;
        if (dad.right == parent) {
            dad.right = parent.left;
            parent.left = dad;
        }
        if (dad.left == parent) {
            dad.left = parent.right;
            parent.right = dad;
        }

        parent.isRed = false;
        dad.isRed = false;
        if (parent.left != null) {
            parent.left.isRed = false;
        }
    }

    private void LrotateLeft(Node dad, Node parent, Node current) {
        parent.right = current.left;
        current.left = parent;
        dad.left = current;


        dad.isRed = false;
        parent.isRed = false;
        current.isRed = false;
        if (current.right != null) {
            current.right.isRed = false;
        }
    }

    private void RrotateRightRoot1() {
        boolean isRoot = false;
        if (root == grandDad) {
            isRoot = true;
        }
        Node temp = grandDad;

        grandDad = grandDad.right;
        temp.right = grandDad.left;
        grandDad.left = temp;

        if (isRoot) {
            root = grandDad;
        }

        grandDad.isRed = false;
        grandDad.right.isRed = false;
    }

    private void RrotateRight(Node grandDad, Node dad, Node parent) {
        grandDad.right = parent;
        if (dad.right == parent) {
            dad.right = parent.left;
            parent.left = dad;
        }
        if (dad.left == parent) {
            dad.left = parent.right;
            parent.right = dad;
        }

        parent.isRed = false;
        dad.isRed = false;
        if (parent.right != null) {
            parent.right.isRed = false;
        } else {
            parent.left.isRed = false;
        }
    }

    private void RrotateLeft(Node dad, Node parent, Node current) {
        parent.left = current.right;
        current.right = parent;
        dad.right = current;

        dad.isRed = dad != root;
        parent.isRed = true;
        current.isRed = false;
        if (current.left != null) {
            current.left.isRed = false;
        }
    }

    private void defaultSet(Node parent) {
        if (!parent.isRed) {
            if (parent != root) {
                parent.isRed = true;
            }

            parent.right.isRed = false;
            parent.left.isRed = false;
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public boolean delete(int data) {
        Node current = root;
        Node parent = root;
        boolean isleft = true;

        while (current.data != data) {
            parent = current;
            if (data < current.data) {
                isleft = true;
                current = current.left;
            } else {
                isleft = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isleft) {
                parent.left = null;
                if (parent.right != null) {
                    parent.right.isRed = true;
                }
            } else {
                parent.right = null;
                if (parent.left != null) {
                    parent.left.isRed = true;
                }
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isleft) {
                current.left.isRed = parent.left.isRed;
                parent.left = current.left;
            } else {
                current.left.isRed = parent.right.isRed;
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isleft) {
                current.right.isRed = parent.left.isRed;
                parent.left = current.right;
            } else {
                parent.right = current.right;
                current.right.isRed = parent.right.isRed;
            }
        } else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if(isleft) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }

        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
            successor.left = delNode.left;
            successor.isRed = delNode.isRed;
        }

        return successor;
    }

    @Override
    public String toString() {
        String output = "";

        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 35;
        boolean isRowEmpty = false;

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                output += ' ';
            }

            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    output += temp.data + "-" + (temp.isRed ? "R" : "B");
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    output += "----";
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    output += ' ';
                }
            }

            output += "\n";
            nBlanks /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }

        return output + ". . .\n";
    }

    public void delete() {
        root = null;
        nElems = 0;
    }
}
