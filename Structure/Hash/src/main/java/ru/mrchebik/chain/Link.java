package ru.mrchebik.chain;

/**
 * Created by mrchebik on 30.04.17.
 */
public class Link {
    private int data;
    public Link next;

    public Link (int it) {
        data = it;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
