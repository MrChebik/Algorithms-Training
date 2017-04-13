package structure;

/**
 * Created by mrchebik on 13.04.17.
 */
public class Node {
    int col;
    char letter;

    Node leftChild;
    Node rightChild;

    public Node(int col) {
        this.col = col;
    }

    public Node(int col, char letter) {
        this.col = col;
        this.letter = letter;
    }

    Node(int col, Node leftChild, Node rightChild) {
        this.col = col;

        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String toString() {
        return col + (letter == 0 ? "" : ("'" + letter + "'"));
    }
}
