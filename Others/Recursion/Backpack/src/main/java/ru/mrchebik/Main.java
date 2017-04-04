package ru.mrchebik;

/**
 * Created by mrchebik on 03.04.17.
 */
public class Main {
    private static int[] items = new int[] {11, 8, 7, 6, 5};
    private static int[] backpack = new int[items.length];
    private static int length = 0;

    public static void main(String[] args) {
        doAdd(20);
    }

    public static void doAdd(int expected) {
        addToBackpack(expected, 0, 0);

        for (int i = 0; i < length; i++) {
            System.out.print(backpack[i] + " ");
        }
    }

    private static int addToBackpack(int expected, int number, int actual) {
        if (actual == expected) {
            return actual;
        }

        if (number + 1 == items.length && actual + items[number] != expected) {
            if (find(backpack[length]) == items.length - 1 || length == 0) {
                return -1;
            }
            int temp = find(backpack[--length]);

            return addToBackpack(expected, temp + 1, actual - items[temp]);
        }

        if (actual + items[number] <= expected) {
            backpack[length] = items[number];

            length++;
            return addToBackpack(expected, number + 1, actual + items[number]);
        } else {
            return addToBackpack(expected, number + 1, actual);
        }
    }

    private static int find(int key) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
