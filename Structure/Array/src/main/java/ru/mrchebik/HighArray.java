package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class HighArray extends LowArray {
    private int nElems = 0;

    public HighArray(int size) {
        super(size);
    }

    private int find(long value) {
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

    public void delete(long value) {
        shiftToLeft(find(value));
    }

    public boolean isExist(long value) {
        for (long anArray : array) {
            if (anArray == value) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return array.length;
    }

    /**
     * Tasks
     *
    // Get max value
    public long getMax() {
        long max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        if (max == 0) {
            return -1;
        }

        return max;
    }

    // Remove max value
    public void removeMax() {
        shiftToLeft(find(getMax()));
    }

    // Primitive sorting
    public long removeMaxAndGet() {
        long max = getMax();
        shiftToLeft(find(max));

        return max;
    }

    // Method that removes all duplicates
    public long[] noDups() {
        long[] subArray = new long[array.length];
        int temp, col = 0;

        for (int i = 0, k = 0; i < array.length; i++) {
            temp = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == subArray[j]) {
                    temp++;
                    break;
                }
            }

            if (temp == 0) {
                subArray[k++] = array[i];
                col++;
            }
        }

        return subArray;
    }
     */

    private void shiftToLeft(int index) {
        for (int j = index; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }

        if (nElems-- == array.length) {
            array[array.length - 1] = 0;
        }
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
