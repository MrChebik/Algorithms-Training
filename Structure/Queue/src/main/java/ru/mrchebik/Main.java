package ru.mrchebik;

/**
 * Created by mrchebik on 18.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(10);
        queue.insert(15);

        System.out.println(queue.size());

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
