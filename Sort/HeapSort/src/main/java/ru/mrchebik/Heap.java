package ru.mrchebik;

/**
 * Created by mrchebik on 05.05.17.
 */
public class Heap {
    private Node[] heapArray;
    private int currentSize;

    public Heap(int size) {
        heapArray = new Node[size];
        currentSize = 0;
    }

    public void insertAt(int index, Node newNode) {
        heapArray[index] = newNode;
    }

    public void incrementSize() {
        currentSize++;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);

        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getData() < heapArray[rightChild].getData()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getData() >= heapArray[largerChild].getData()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public void displayArray() {
        for (Node aHeapArray : heapArray) {
            System.out.print(aHeapArray.getData() + " ");
        }
        System.out.println();
    }
}
