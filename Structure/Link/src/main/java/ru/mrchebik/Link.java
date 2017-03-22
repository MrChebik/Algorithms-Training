package ru.mrchebik;

/**
 * Created by mrchebik on 21.03.17.
 */
public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    @Override
    public String toString() {
        return "{" + iData + ", " + dData + "}";
    }
}
