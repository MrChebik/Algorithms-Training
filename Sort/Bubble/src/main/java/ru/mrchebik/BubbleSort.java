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
}
