package ru.mrchebik;

/**
 * Created by mrchebik on 13.03.17.
 */
public class BinarySearch {
    private static final long[] array = new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static void main(String[] args) {
        System.out.println(binary(array, 9));
    }

    public static int binary(long[] array, int searchKey) {
        int lowerBound = 0;
        int upperBound = array.length - 1;
        int current;

        while (true) {
            current = (lowerBound + upperBound) / 2;

            if (array[current] == searchKey) {
                return current;
            } else {
                if (lowerBound > upperBound) {
                    return -1;
                } else {
                    if (array[current] > searchKey) {
                        upperBound = current - 1;
                    } else {
                        lowerBound = current + 1;
                    }
                }
            }
        }
    }
}
