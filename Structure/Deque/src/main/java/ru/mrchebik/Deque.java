package ru.mrchebik;

/**
 * Created by mrchebik on 19.03.17.
 */
public class Deque {
    private long[] dequeArray;
    // Stack
    private int first;

    // Queue
    private int last;
    private int front;

    // If front = last
    private boolean switcher;

    private int nElems;

    public Deque(int size) {
        dequeArray = new long[size];
        first = -1;
        last = size;
        front = size - 1;
        switcher = false;
    }

    public void addFirst(int element) {
        if (dequeArray[first + 1] == 0) {
            dequeArray[++first] = element;
            nElems++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Max size for Stack Structure");
        }
    }

    public void addLast(int element) {
        if (first == dequeArray.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Max size for Queue Structure");
        }
        if (last - 1 == first) {
            last = dequeArray.length;
        }
        dequeArray[--last] = element;
        switcher = false;
        nElems++;
    }

    public long getFirst() {
        if (first != -1) {
            return dequeArray[first];
        } else {
            return -1;
        }
    }

    public long getLast() {
        if (!switcher) {
            if (front == last) {
                switcher = true;
            }
            return dequeArray[front];
        } else {
            return -1;
        }
    }

    public long removeFirst() {
        nElems--;
        long temp = dequeArray[first];
        dequeArray[first--] = 0;
        return temp;
    }

    public long removeLast() {
        long temp = dequeArray[front];
        dequeArray[front--] = 0;
        if (front == -1 || dequeArray[front] == 0 || front == first) {
            front = dequeArray.length - 1;
        }
        nElems--;

        return temp;
    }

    public int size() {
        return nElems;
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public boolean isFull() {
        return nElems == dequeArray.length - 1;
    }
}
