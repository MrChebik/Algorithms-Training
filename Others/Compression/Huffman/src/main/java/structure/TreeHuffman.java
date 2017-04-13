package structure;

import java.util.Stack;

/**
 * Created by mrchebik on 13.04.17.
 */
public class TreeHuffman implements Comparable<TreeHuffman> {
    public Node root;

    private String lineOut;
    private String lineBit;
    private String lineStandart;
    public ArrayHuffman codes;

    private TreeHuffman tree;

    public TreeHuffman(TreeHuffman tree0, TreeHuffman tree1) {
        this.root = new Node(tree0.root.col + tree1.root.col, tree0.root, tree1.root);
    }

    public TreeHuffman(Node root) {
        this.root = root;
    }

    public void find(Node current, String code) {
        if (current.leftChild != null) {
            find(current.leftChild, code + "0");
        } if (current.rightChild != null) {
            find(current.rightChild, code + "1");
        } else {
            codes.insert(current.letter, code);
        }
    }

    public void find(Node current, String code, int size) {
        if (current.leftChild == null || current.rightChild == null) {
            lineOut += codes.find(code);
            if (lineBit.length() != size) {
                find(tree.root, "", size);
            }
        } else {
            if (lineBit.charAt(size) == '0') {
                find(current.leftChild, code + "0", size + 1);
            } else {
                find(current.rightChild, code + "1", size + 1);
            }
        }
    }

    public String decoding(TreeHuffman tree) {
        lineOut = "";
        this.tree = tree;
        find(tree.root, "", 0);
        return lineOut;
    }

    public String setLine() {
        this.lineBit = "";
        for (int i = 0; i < lineStandart.length(); i++) {
            this.lineBit += codes.find(lineStandart.charAt(i));
        }
        return lineBit;
    }

    public void setLineStandart(String lineStandart) {
        this.lineStandart = lineStandart;
        codes = new ArrayHuffman(lineStandart.length());
    }

    @Override
    public String toString() {
        String output = ". . .\n";

        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
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
                    if (temp.col != 0) {
                        output += temp;
                        localStack.push(temp.leftChild);
                        localStack.push(temp.rightChild);

                        if (temp.leftChild != null || temp.rightChild != null) {
                            isRowEmpty = false;
                        }
                    }
                } else {
                    output += "-";
                    localStack.push(new Node(0));
                    localStack.push(new Node(0));
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

    public int compareTo(TreeHuffman o) {
        if (root.col > o.root.col) {
            return 1;
        } else {
            return -1;
        }
    }
}
