package ru.mrchebik;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mrchebik on 18.03.17.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
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
        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();

        PriorityQueue priorityQueue = new PriorityQueue(5);

        priorityQueue.insert(30);
        priorityQueue.insert(90);
        priorityQueue.insert(60);
        priorityQueue.insert(50);
        priorityQueue.insert(100);

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.remove() + " ");
        }
        System.out.println();

        queueCustomersImitating();
    }

    /**
     * Example of using Queue.
     * Queue customers in the cash register in the store
     */
    private static Queue[] queues = new Queue[5];

    // Value -- the number of products
    private static int customer;

    public static void queueCustomersImitating() throws IllegalAccessException {
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new Queue(5);
            queues[i].insert(3);
            startTimer(i, 3);
        }

        Queue temp;
        for (int i = 0; i < 100; i++) {
            customer = new Random().nextInt(10) + 3;
            do {
                temp = queues[0];
                if (!temp.isEmpty()) {
                    for (int j = 1; j < 5; j++) {
                        if (queues[j].isEmpty()) {
                            temp = queues[j];
                            break;
                        } else {
                            if (temp.size() > queues[j].size()) {
                                temp = queues[j];
                            }
                        }
                    }
                }
            } while (temp.isFull());

            temp.insert(customer);
            System.out.println(temp + " // " + i);
        }
    }

    private static void startTimer(final int index, long period) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                queues[index].remove();
                this.cancel();
                startTimer(index, queues[index].peekFront());
            }
        }, period * 1000, 1);
    }
}
