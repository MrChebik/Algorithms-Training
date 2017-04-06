import java.util.Arrays;
import java.util.Random;

/**
 * Created by mrchebik on 06.04.17.
 */
public class Main {
    private static long[] array = new long[10];

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(9) + 1;
        }

        long pivot = 4;

        System.out.println(Arrays.toString(array) + "\nPivot is " + pivot + ". Partition is at index " + partitionIt(0, array.length - 1, pivot) + "\n" + Arrays.toString(array));
    }

    public static int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && array[++leftPtr] < pivot);
            while (rightPtr > left && array[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                long temp = array[leftPtr];
                array[leftPtr] = array[rightPtr];
                array[rightPtr] = temp;
            }
        }

        return leftPtr;
    }
}
