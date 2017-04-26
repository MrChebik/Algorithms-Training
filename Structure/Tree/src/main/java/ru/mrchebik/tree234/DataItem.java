package ru.mrchebik.tree234;

/**
 * Created by mrchebik on 26.04.17.
 */
public class DataItem {
    public long data;

    public DataItem(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "/" + data;
    }
}
