package ru.mrchebik;

/**
 * Created by mrchebik on 19.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.addFirst(1);
        deque.addFirst(2);
        deque.removeFirst();
        deque.removeFirst();
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.removeLast();
        deque.removeLast();
        deque.addLast(4);
        deque.addLast(3);

        while (deque.getFirst() != -1) {
            System.out.print(deque.removeFirst() + " ");
        }

        while (deque.getLast() != -1) {
            System.out.print(deque.removeLast() + " ");
        }
    }
}
