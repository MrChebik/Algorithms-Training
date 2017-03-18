package ru.mrchebik;

import java.util.Arrays;

/**
 * Created by mrchebik on 14.03.17.
 */
public class BubbleSort {
    private static int[] array = new int[] { 2, 16, 8, 18, 12, 1, 7, 14, 10, 15, 9, 13, 6, 5, 4, 3, 11, 17, 20, 19 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubble(array)));
    }

    public static int[] bubble(int[] array) {
        int temp, k, i;

        for (k = array.length - 1; k > 1; k--) {
            for (i = 0; i < k; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }

    /**
     * Tasks
     *
    // Sort from left to right. At the end, changes direction from right to left
    public static int[] bubbleAndReverse(int[] array) {
        int k, i, j = 0, l;

        for (k = array.length - 1, l = 0; k > array.length / 2; k--, l++) {
            for (i = j; i < k; i++) {
                if (array[i] > array[i + 1]) {
                    array[i] = swap(array[i + 1], array[i + 1] = array[i]);
                }
            }
            for (j = i; j > l; j--) {
                if (array[j] < array[j - 1]) {
                    array[i] = swap(array[i + 1], array[i + 1] = array[i]);
                }
            }
        }

        return array;
    }

    // Sort of odd
    // 0 2 4 6 ...
    // 1 3 5 7 ...
    // --- Support asynchronous sorting ---
    public static int[] oddEvenSort(int[] array) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length - (array.length % 2 == 0 ? 2 : 0); i += 2) {
                if (array[i] > array[i + 1]) {
                    array[i] = swap(array[i + 1], (array[i + 1] = array[i]));
                    isSorted = false;
                }
            }

            for (int i = 0; i < array.length - (array.length % 2 == 0 ? 0 : 2); i += 2) {
                if (array[i] > array[i + 1]) {
                    array[i] = swap(array[i + 1], (array[i + 1] = array[i]));
                    isSorted = false;
                }
            }
        }

        return array;
    }

    // Other realization without asynchronous sorting
    public static int[] evenOddSort(int[] array) {
        for (int k = array.length; k > 0; k--) {
            for (int i = k % 2 == 0 ? 0 : 1; i < array.length - (k % 2 == 0 ? 0 : 1); i += 2) {
                if (array[i] > array[i + 1]) {
                    array[i] = swap(array[i + 1], array[i + 1] = array[i]);
                }
            }
        }

        return array;
    }

    public static int swap(int a, int b) {
        return a;
    }
     */
}
