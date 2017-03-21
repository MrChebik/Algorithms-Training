package ru.mrchebik;

/**
 * Created by mrchebik on 18.03.17.
 */
public class Queue {
    private long[] queueArray;
    private int front;
    private int rear;

    public Queue(int size) {
        queueArray = new long[size + 1];
        front = 0;
        rear = -1;
    }

    public void insert(long item) {
        if (rear == queueArray.length - 1) {
            rear = -1;
        }
        queueArray[++rear] = item;
    }

    public long remove() {
        long temp = queueArray[front++];
        if (front == queueArray.length) {
            front = 0;
        }

        return temp;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return rear + 1 == front || (front + queueArray.length - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front) || (front + queueArray.length - 2 == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (queueArray.length - front) + (rear + 1);
        }
    }

    // Output array
    @Override
    public String toString() {
        String output = "";

        if (rear != -1) {
            int i = front - 1;
            do {
                i++;
                if (i == queueArray.length) {
                    i = 0;
                }
                if (i == 0 && rear == 0) {
                    return output += queueArray[i];
                } else {
                    output += queueArray[i] + " ";
                }
            } while (i != rear);
            return output;
        } else {
            return "-1";
        }
    }

}
