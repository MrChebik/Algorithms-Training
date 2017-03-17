package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class Array {
    private long[] array;

    public Array(int size) {
        array = new long[size];
    }

    public void set(int index, long value) {
        array[index] = value;
    }

    public long get(int index) {
        return array[index];
    }


    // Necessary realizations

    private int nElems = 0;

    private void shift(int index) {
        for (int j = index; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }

        if (nElems-- == array.length) {
            array[array.length - 1] = 0;
        }
    }

    public int findIndex(long value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void insert(long value) {
        array[nElems++] = value;
    }

    public void deleteValue(long value) {
        shift(findIndex(value));
    }

    public void deleteIndex(int index) {
        shift(index);
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
