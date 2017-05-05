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

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == heapArray.length) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);

        return true;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while(index > 0 && heapArray[parent].getData() < bottom.getData()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);

        return root;
    }

    private void trickleDown(int index) {
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

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getData();
        heapArray[index].setData(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }

        return true;
    }

    @Override
    public String toString() {
        String output = "heapArray: ";
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                output += heapArray[m].getData() + ' ';
            } else {
                output += "-- ";
            }
        }
        output += "\n";

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "....................";
        output += dots + dots;

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    output += ' ';
                }
            }
            output += heapArray[j].getData();
            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                output += '\n';
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    output += ' ';
                }
            }
        }

        return output + "\n" + dots + dots;
    }
}
