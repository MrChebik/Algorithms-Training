package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class OrderedArray {
    private long[] array;
    private int nElemsOrder;

    public OrderedArray(int size) {
        array = new long[size];
        nElemsOrder = -1;
    }

    public int find(int value) {
        return BinarySearch.binary(array, value);
    }

    public void insert(int value) {
        if (nElemsOrder == -1 ) {
            array[++nElemsOrder] = value;
        } else {
            int lowerBound = 0;
            int upperBound = nElemsOrder;
            int current;

            while (true) {
                current = (lowerBound + upperBound) / 2;

                if (lowerBound >= upperBound) {
                    if (array[lowerBound] < value) {
                        lowerBound++;
                    }
                    shiftToRight(lowerBound);
                    array[lowerBound] = value;
                    nElemsOrder++;
                    break;
                } else {
                    if (array[current] > value) {
                        upperBound = current - 1;
                    } else {
                        lowerBound = current + 1;
                    }
                }
            }
        }
    }

    public void delete(int value) {
        shiftToLeft(BinarySearch.binary(array, value));
        nElemsOrder--;
    }

    public int size() {
        return array.length;
    }

    /**
     * Tasks
     *
    // Merge two sorted arrays to one
    public OrderedArray merge(OrderedArray array1, OrderedArray array2) {
        long[] arr1 = array1.array;
        long[] arr2 = array2.array;
        int switchOrder = 0;

        for (int i = 0, j = 0, k = 0; i < array.length; i++) {
            if (switchOrder == 0) {
                if (arr1[j] < arr2[k]) {
                    array[i] = arr1[j++];
                } else {
                    array[i] = arr2[k++];
                }
            } else {
                if (switchOrder == 1) {
                    array[i] = arr2[k++];
                } else {
                    array[i] = arr1[j++];
                }
            }

            if (j == arr1.length && k == arr2.length) {
                break;
            }

            if (j == arr1.length) {
                switchOrder = 1;
            }
            if (k == arr2.length) {
                switchOrder = 2;
            }
        }

        return this;
    }
     */

    private void shiftToLeft(int index) {
        for (int j = index; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }

        if (nElemsOrder == array.length - 1) {
            array[array.length - 1] = 0;
        }
    }

    private void shiftToRight(int index) {
        for (int j = nElemsOrder + 1; j > index; j--) {
            array[j] = array[j - 1];
        }
    }

    @Override
    public String toString() {
        String arrayString = "";

        for (long element : array) {
            arrayString += element + " ";
        }

        return arrayString;
    }
}
