package ru.mrchebik;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrchebik on 05.04.17.
 */
public class Main {
    private static int[] items = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < items.length; i++) {
            items[i] = new Random().nextInt(99) + 1;
        }

        System.out.println(Arrays.toString(items));

        shellSort(items);

        System.out.println(Arrays.toString(items));
    }

    public static void shellSort(int[] array) {
        int inner, outer, temp, h = 1;

        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }

                array[inner] = temp;
            }

            h = (h - 1) / 3;
        }
    }
}
