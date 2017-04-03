package ru.mrchebik;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrchebik on 03.04.17.
 */
public class Main {
    private static long[] array = new long[10];

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }

        System.out.println(Arrays.toString(array));

        mergeSort();

        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort() {
        long[] workSpace = new long[array.length];
        recMergeSort(workSpace, 0, array.length - 1);
    }

    private static void recMergeSort(long[] workSpace, int lower, int upper) {
        if (lower == upper) {
            return;
        } else {
            int mid = (lower + upper) / 2;
            recMergeSort(workSpace, lower, mid);
            recMergeSort(workSpace, mid + 1, upper);

            merge(workSpace, lower, mid + 1, upper);
        }
    }

    private static void merge(long[] workSpace, int low, int high, int upper) {
        int j = 0;
        int lower = low;
        int mid = high - 1;
        int n = upper - lower + 1;

        while (low <= mid && high <= upper) {
            if (array[low] < array[high]) {
                workSpace[j++] = array[low++];
            } else {
                workSpace[j++] = array[high++];
            }
        }

        while (low <= mid) {
            workSpace[j++] = array[low++];
        }

        while (high <= upper) {
            workSpace[j++] = array[high++];
        }

        for (j = 0; j < n; j++) {
            array[lower + j] = workSpace[j];
        }
    }
}
