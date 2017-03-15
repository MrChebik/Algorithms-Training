package ru.mrchebik;

import java.util.Arrays;

/**
 * Created by mrchebik on 14.03.17.
 */
public class InsertSort {
    private static int[] array = new int[] { 2, 16, 8, 18, 12, 1, 7, 14, 10, 15, 9, 13, 6, 5, 4, 3, 11, 17, 20, 19 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert(array)));
    }

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
}
