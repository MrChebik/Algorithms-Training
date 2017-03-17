package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class LowArray {
    protected long[] array;

    public LowArray(int size) {
        array = new long[size];
    }

    public void set(int index, long value) {
        array[index] = value;
    }

    public long get(int index) {
        return array[index];
    }

    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        String arrayString = "";

        for (long element : array) {
            arrayString += element + " ";
        }

        return arrayString;
    }
}
