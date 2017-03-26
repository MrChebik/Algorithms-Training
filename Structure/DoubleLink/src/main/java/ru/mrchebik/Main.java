package ru.mrchebik;

/**
 * Created by mrchebik on 26.03.17.
 */
public class Main {
    public static void main(String[] args) {
        DoubleLinkedListDeque deque = new DoubleLinkedListDeque();

        deque.insertStack(22);
        deque.insertStack(33);

        System.out.println(deque);

        deque.deleteStack();

        System.out.println(deque);

        deque.insertQueue(11);
        deque.insertQueue(44);

        System.out.println(deque);

        deque.deleteQueue();

        System.out.println(deque);

        deque.insertQueue(55);
        deque.insertStack(105);

        System.out.println(deque);

        deque.deleteQueue();
        deque.deleteStack();
        deque.deleteStack();
        deque.deleteQueue();

        System.out.println(deque);
    }
}
