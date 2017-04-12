import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mrchebik on 12.04.17.
 */
public class Main {
    private static Queue[] numbers = new Queue[10];
    private static String[] standartNumbers = {"421", "240", "035", "532", "305", "430", "124"};

    public static void main(String[] args) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new LinkedList();
        }

        System.out.println(Arrays.toString(standartNumbers));
        bitwise(standartNumbers[0].length() - 1);
        System.out.println(Arrays.toString(standartNumbers));
    }

    public static void bitwise(int col) {
        for (; col > -1; col--) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < standartNumbers.length; j++) {
                    if (standartNumbers[j].charAt(col) == i + 48) {
                        numbers[i].add(standartNumbers[j]);
                    }
                }
            }

            int i = 0;

            for (int j = 0; j < 10; j++) {
                while (!numbers[j].isEmpty()) {
                    standartNumbers[i++] = String.valueOf(numbers[j].remove());
                }
            }
        }
    }
}
