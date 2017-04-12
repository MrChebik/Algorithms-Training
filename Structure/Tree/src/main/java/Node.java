/**
 * Created by mrchebik on 12.04.17.
 */
public class Node {
    int data;

    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
