package ru.mrchebik;

import java.util.Arrays;

/**
 * Created by mrchebik on 14.03.17.
 */
public class InsertSort {
    private static int[] array = new int[] { 2, 16, 8, 18, 12, 1, 7, 14, 10, 15, 9, 13, 6, 5, 4, 3, 11, 17, 19 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert(array)));
    }

    // Unsorted elements (20) has near 166 comparisons and 119 copies.
    // Part of the sorted (1/3) elements (20) has near 54 comparisons and 63 copies.
    public static int[] insert(int[] array) {
        int in, i;

        for (i = 1; i < array.length; i++) {
            int temp = array[in = i];
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[--in];
            }
            array[in] = temp;
        }

        return array;
    }

    /**
     * Tasks
     *
    // Median of array.
    // If I must to use Insert Sort, I don't know answer of this question.
    // I can take element, and check of position, i.e.
    // [0 6 1 3 4] -- median 3
    // I get 3 and start to check.
    // [3 | 6 1 0 4]
    // At the end, I must to get this.
    // [0 1 3 6 | 4]
    // And if I put 4 to the sorted array, and 3 was at middle, it's median.
    // But if I just sort the array and divide the length by 2, I get the median.
    //
    // Selection Sort can resolve this at O(n)
    public static int median(int[] array) {
        return array[insert(array).length / 2];
    }

    // Method that removes all duplicates and shift element must be only one.
    public static int[] noDups(int[] array) {
        int temp, col = 0, n = 0;

        for (int i = 0; i < array.length; i++) {
            temp = 0;
            for (int j = i + 1 + col; j < array.length; j++) {
                if (array[i] == array[j]) {;
                    temp++;
                } else {
                    break;
                }
            }
            if (temp != 0) {
                array[i + 1] = array[(n = i + (col += temp)) + 1 == array.length ? n : n + 1];
            }
            if (n + 1 >= array.length) {
                for (int j = i + 1; j < array.length; j++) {
                    array[j] = 0;
                }

                return array;
            }
        }

        return new int[] { -1 };
    }

    // Removal of duplicates during sorting
    public static int[] insertNoDups(int[] array) {
        int in, i, col = 0;

        for (i = 1; i < array.length; i++) {
            int temp = array[in = i];
            while (in > col && array[in - 1] >= temp) {
                if (array[in - 1] == temp) {;
                    temp = -1;
                }
                array[in] = array[--in];
            }
            if (temp == -1) {
                col++;
            }
            array[in] = temp;
        }
        for (int j = 0; j < array.length - col; j++) {
            array[j] = array[col + j];
        }
        for (int j = array.length - col; j < array.length; j++) {
            array[j] = 0;
        }

        return array;
    }
     */
}
