package ru.mrchebik;

/**
 * Created by mrchebik on 23.03.17.
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        dData = dd;
    }

    @Override
    public String toString() {
        return dData + ", ";
    }
}
