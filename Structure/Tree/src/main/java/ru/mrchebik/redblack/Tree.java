package ru.mrchebik.redblack;

import java.util.Stack;

/**
 * Created by mrchebik on 15.04.17.
 */

/**
 * NOT STABILITY!!!
 */
public class Tree {
    private Node root;

    private Node grandDad;
    private Node dad;
    private Node parent;

    private byte nElems = 0;

    public Tree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            newNode.isRed = false;
        } else {
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

                doCheck(grandDad, dad, parent, current);

                if (data < current.data) {
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

                                if (parent.isRed && newNode.isRed && parent.left == newNode && dad.left == parent && grandDad.left == dad) {
                                    LrotateRight(grandDad, dad, parent);
                                } else if (parent.isRed && newNode.isRed && parent.left == newNode && grandDad.right == dad && dad.right == parent) {
                                    RrotateLeft(dad, parent, newNode);
                                    RrotateRightRoot();
                                } else if (parent.isRed && newNode.isRed && parent.left == newNode && grandDad.right == dad && dad.left == parent) {
                                    RrotateRight(grandDad, dad, parent);
                                } else if (parent.isRed && newNode.isRed && parent.left == newNode && grandDad.left == dad && dad.right == parent){
                                    RrotateRight(dad, parent, newNode);
                                    LrotateRight(grandDad, dad, dad.right);
                                }

                                doFixCheck();
                                doFixBlack();
                            }
                        }

                        return;
                    }
                } else {
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

                                if (parent.isRed && newNode.isRed && parent.right == newNode && dad.right == parent && grandDad.right == dad) {
                                    RrotateRight(grandDad, dad, parent);
                                } else if (parent.isRed && newNode.isRed && parent.right == newNode && grandDad.left == dad && dad.left == parent) {
                                    LrotateLeft(dad, parent, newNode);
                                    LrotateRightRoot();
                                } else if (parent.isRed && newNode.isRed && parent.right == newNode && grandDad.right == dad && dad.left == parent) {
                                    LrotateLeft(dad, parent, newNode);
                                    RrotateRight(grandDad, dad, dad.left);
                                } else if (parent.isRed && newNode.isRed && parent.right == newNode && grandDad.left == dad && dad.right == parent) {
                                    LrotateRight(grandDad, dad, parent);
                                }

                                doFixCheck();
                                doFixBlack();
                            }
                        }

                        return;
                    }
                }
            }
        }
    }

    private void doFixCheck() {
        fixCheck(root, root, null, root);
    }

    private void fixCheck(Node grandDad, Node dad, Node parent, Node current) {
        if (current != null) {
            if (dad != root) {
                grandDad = dad;
            }
            if (parent != null) {
                dad = parent;
            }
            parent = current;

            doCheck(grandDad, dad, parent, current);

            fixCheck(grandDad, dad, parent, current.left);
            fixCheck(grandDad, dad, parent, current.right);
        }
    }

    private void doCheck(Node grandDad, Node dad, Node parent, Node current) {
        if (current.left != null && current.right != null) {
            if (current.left.isRed && current.right.isRed) {
                current.left.isRed = false;
                current.right.isRed = false;

                if (current != root) {
                    current.isRed = true;
                }
            }

            if (dad.left != null) {
                if (dad.isRed && dad.left.isRed && root.left == dad) {
                    LrotateRightRoot();
                }
            } else if (dad.left != null) {
                if (dad.isRed && dad.left.isRed && root.right == dad) {
                    RrotateLeft(grandDad, dad, current);
                    RrotateRightRoot();
                }
            } else if (dad.right != null) {
                if (dad.isRed && dad.right.isRed && root.right == dad) {
                    RrotateRightRoot();
                }
            } else if (dad.right != null) {
                if (dad.isRed && dad.right.isRed && root.left == dad) {
                    LrotateLeft(dad, parent, current);
                    LrotateRightRoot();
                }
            }

            if (dad.isRed && parent.isRed && dad.right == parent && grandDad.right == dad) {
                RrotateRight(grandDad, dad, parent);
            } else if (dad.isRed && parent.isRed && dad.right == parent && grandDad.left == dad) {
                LrotateLeft(grandDad, dad, parent);
                LrotateRightRoot();
            } else if (dad.isRed && parent.isRed && dad.right == parent && grandDad.right == dad) {
                LrotateLeft(grandDad, dad, parent);
                RrotateRight(grandDad, dad, dad.left);
            } else if (dad.isRed && parent.isRed && dad.right == parent && grandDad.left == dad) {
                LrotateRight(grandDad, dad, parent);
            } else if (dad.isRed && parent.isRed && dad.left == parent && grandDad.left == dad) {
                LrotateRight(grandDad, dad, parent);
            } else if (dad.isRed && parent.isRed && dad.left == parent && grandDad.right == dad) {
                RrotateLeft(grandDad, dad, parent);
                RrotateRightRoot();
            } else if (dad.isRed && parent.isRed && dad.left == parent && grandDad.right == dad) {
                RrotateRight(grandDad, dad, parent);
            } else if (dad.isRed && parent.isRed && dad.left == parent && grandDad.left == dad) {
                RrotateRight(grandDad, dad, parent);
                LrotateRight(grandDad, dad, dad.right);
            }
        }
    }

    private void doFixBlack() {
        int Lblack = needFixBlack(root.left, 0);
        int Rblack = needFixBlack(root.right, 0);

        if (Math.abs(Lblack - Rblack) > 1) {
            if (Lblack < Rblack) {
                RrotateRightRoot();
            } else {
                LrotateRightRoot();
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

    private void LrotateRightRoot() {
        Node temp = root;

        root = root.left;
        temp.left = root.right;
        root.right = temp;

        root.isRed = false;
        grandDad.isRed = false;
        parent.isRed = false;
        if (parent.left != null) {
            parent.left.isRed = false;
        }
    }

    private void LrotateRight(Node grandDad, Node dad, Node parent) {
        grandDad.left = parent;
        if (dad.right == parent) {
            parent.left = dad;
            dad.right = null;
        }
        if (dad.left == parent) {
            parent.right = dad;
            dad.left = null;
        }

        parent.isRed = false;
        dad.isRed = dad != root;
    }

    private void LrotateLeft(Node dad, Node parent, Node current) {
        parent.right = current.left;
        current.left = parent;
        dad.left = current;


        dad.isRed = dad != root;
        parent.isRed = parent != root;
        current.isRed = false;
    }

    private void RrotateRightRoot() {
        Node temp = root;

        root = root.right;
        temp.right = root.left;
        root.left = temp;

        root.isRed = false;
        root.left.isRed = false;
    }

    private void RrotateRight(Node grandDad, Node dad, Node parent) {
        grandDad.right = parent;
        if (dad.right == parent) {
            parent.left = dad;
            dad.right = null;
        }
        if (dad.left == parent) {
            parent.right = dad;
            dad.left = null;
        }

        parent.isRed = false;
        dad.isRed = dad != root;
    }

    private void RrotateLeft(Node dad, Node parent, Node current) {
        parent.left = current.right;
        current.right = parent;
        dad.right = current;

        dad.isRed = dad != root;
        parent.isRed = true;
        current.isRed = false;
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

    private int needFixBlack(Node node, int col) {
        if (node != null) {
            if (!node.isRed) {
                col++;
            }
            col = needFixBlack(node.left, col);
            col = needFixBlack(node.right, col);
        }

        return col;
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
