package ru.mrchebik;

/**
 * Created by mrchebik on 05.05.17.
 */

/**
 * Always take O(N*logN)
 * But Quick Sort can change speed from O(logN) to O(N^2)
 */
public class Main {
    private static int size = 10;
    private static Heap heap = new Heap(size);

    public static void main(String[] args) {
        for (int j = 0; j < size; j++) {
            int random = (int) (Math.random() * 100);
            Node newNode = new Node(random);
            heap.insertAt(j, newNode);
            heap.incrementSize();
        }

        heap.displayArray();

        heapSort();

        heap.displayArray();
    }

    public static void heapSort() {
        int j;
        for (j = size / 2 - 1; j >= 0; j--) {
            heap.trickleDown(j);
        }

        for (j = size - 1; j >= 0; j--) {
            Node biggestNode = heap.remove();
            heap.insertAt(j, biggestNode);
        }
    }
}
