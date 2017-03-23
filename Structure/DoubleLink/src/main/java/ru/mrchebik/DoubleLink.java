package ru.mrchebik;

/**
 * Created by mrchebik on 22.03.17.
 */
public class DoubleLink {
    public long dData;
    public DoubleLink next;
    public DoubleLink previous;

    public DoubleLink(long data) {
        dData = data;
    }

    public String toString() {
        return dData + " // ";
    }
}
