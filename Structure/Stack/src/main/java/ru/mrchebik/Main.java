package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(100);
        stack.push(1_000);
        stack.push(10_000);
        stack.push(100_000);
        stack.push(1_000_000);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
