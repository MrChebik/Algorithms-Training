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
}
