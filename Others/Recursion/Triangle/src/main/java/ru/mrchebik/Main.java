package ru.mrchebik;

/**
 * Created by mrchebik on 01.04.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(triangle(4));
    }

    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n + triangle(n - 1));
        }
    }
}
