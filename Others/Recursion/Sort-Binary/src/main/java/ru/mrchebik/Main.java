package ru.mrchebik;

/**
 * Created by mrchebik on 02.04.17.
 */
public class Main {
    private static int[] array = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println(find(3));
    }

    public static int find(int key) {
        return recFind(key, 0, array.length);
    }

    private static int recFind(int key, int start, int end) {
        int current = (start + end) / 2;

        if (array[current] == key) {
            return current;
        } else if (start > end) {
            return -1;
        } else {
            if (array[current] < key) {
                return recFind(key, current + 1, end);
            } else {
                return recFind(key, start, current - 1);
            }
        }
    }
}
