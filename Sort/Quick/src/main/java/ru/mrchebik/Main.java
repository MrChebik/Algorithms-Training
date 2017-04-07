package ru.mrchebik;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrchebik on 07.04.17.
 */
public class Main {
    private static int[] array = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(99) + 1;
        }

        System.out.println(Arrays.toString(array));

        quickSort();

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort() {
        recQuickSort(0, array.length - 1);
        // insertionSort(0, array.length - 1);
    }

    private static void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size < 10) {
            insertionSort(left, right);
        } else {
            int median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);

            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private static int medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center])  swap(left, right);
        if (array[left] > array[right])   swap(left, right);
        if (array[center] > array[right]) swap(center, right);

        swap(center, right - 1);

        return array[right - 1];
    }

    private static void swap(int dex1, int dex2) {
        int temp = array[dex1];
        array[dex1] = array[dex2];
        array[dex2] = temp;
    }

    private static int partitionIt(int left, int right, int pivot) {
        int leftPtr  = left;
        int rightPtr = right - 1;

        while (true) {
            while (array[++leftPtr]  < pivot);
            while (array[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        swap(leftPtr, right - 1);

        return leftPtr;
    }

    private static void insertionSort(int left, int right) {
        int in, out;

        for (out = left + 1; out <= right; out++) {
            int temp = array[out];
            in = out;

            while (in > left && array[in - 1] >= temp) {
                array[in] = array[--in];
            }

            array[in] = temp;
        }
    }
}
