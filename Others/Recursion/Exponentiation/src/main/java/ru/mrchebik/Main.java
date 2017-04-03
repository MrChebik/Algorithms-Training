package ru.mrchebik;

/**
 * Created by mrchebik on 03.04.17.
 */
public class Main {
    private static int temp = 1;

    public static void main(String[] args) {
        System.out.println(doPower(3, 11));
    }

    // --- O(log N) ---
    public static int doPower(int number, int degree) {
        return power(number, degree);
    }

    public static int power(int number, int degree) {
        if (degree == 1) {
            return number * temp;
        }

        if (degree % 2 != 0 && degree / 2 != 1) {
            temp *= number;
        }

        return power(number * number, degree / 2);
    }
}
