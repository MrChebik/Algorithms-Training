package ru.mrchebik;

import java.util.Arrays;

/**
 * Created by mrchebik on 14.03.17.
 */
public class SelectionSort {
    private static int[] array = new int[] { 2, 16, 8, 18, 12, 1, 7, 14, 10, 15, 9, 13, 6, 5, 4, 3, 11, 17, 20, 19 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selection(array)));
    }

    public static int[] selection(int[] array) {
        int min, temp, k, i;

        for (k = 0; k < array.length - 1; k++) {
            min = k;
            for (i = k + 1; i < array.length; i++) {
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            temp = array[k];
            array[k] = array[min];
            array[min] = temp;
        }

        return array;
    }
}
