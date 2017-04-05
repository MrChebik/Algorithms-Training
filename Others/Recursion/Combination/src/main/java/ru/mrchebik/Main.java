package ru.mrchebik;

/**
 * Created by mrchebik on 04.04.17.
 */
public class Main {
    private static char[] items = {'A', 'B', 'C', 'D', 'E'};
    private static int col = 3;
    private static char[] combination = new char[col];

    public static void main(String[] args) {
        recCombination(items.length, col);
    }

    public static void recCombination(int n, int k) {
        combination[col - k] = items[items.length - n];

        if (k == 1) {
            System.out.println(combination);
        }

        if (n != 1) {
            if (k != 1) {
                rec(n, k - 1);
            }

            rec(n, k);
        }
    }

    private static void rec(int n, int k) {
        if (n == 2 && k == 1) {
            recCombination(n - 1, k);
        }
        if (n > 2) {
            recCombination(n - 1, k);
        }
    }
}
