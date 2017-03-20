package ru.mrchebik;

/**
 * Created by mrchebik on 19.03.17.
 */
public class PriorityQueue {
    private long[] priorityArray;
    private int nItems;

    public PriorityQueue(int size) {
        priorityArray = new long[size];
        nItems = 0;
    }

    public void insert(long item) {
        int j;

        if (nItems == 0) {
            priorityArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > priorityArray[j]) {
                    priorityArray[j + 1] = priorityArray[j];
                } else {
                    break;
                }
            }
            priorityArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return priorityArray[--nItems];
    }

    public long peekMin() {
        return priorityArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == priorityArray.length;
    }

    /**
     * Tasks
     *
    // --- set        O(1) ---
    // --- get/remove O(N) ---

    public void insertQuickly(long item) {
        priorityArray[nItems++] = item;
    }

    public long removeSlow() {
        int j;
        long item = priorityArray[0];
        int index = 0;

        for (j = 1; j < nItems; j++) {
            if (item > priorityArray[j]) {
                item = priorityArray[j];
                index = j;
            }
        }

        for (int i = index; i < nItems - 1; i++) {
            priorityArray[i] = priorityArray[i + 1];
        }
        nItems--;

        return item;
    }

    // For slow
    @Override
    public String toString() {
        long[] copy = priorityArray.clone();

        int in, i;

        for (i = 1; i < copy.length; i++) {
            long temp = copy[in = i];
            while (in > 0 && copy[in - 1] >= temp) {
                copy[in] = copy[--in];
            }
            copy[in] = temp;
        }

        return Arrays.toString(copy);
    }
     */
}
