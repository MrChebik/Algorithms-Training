package ru.mrchebik.redblack;

/**
 * Created by mrchebik on 15.04.17.
 */
public class Node implements Cloneable {
    int data;

    boolean isRed;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    @Override
    public Node clone() throws CloneNotSupportedException {
        return (Node) super.clone();
    }
}
