package ru.mrchebik;

import java.util.Random;

/**
 * Created by mrchebik on 17.03.17.
 */
public class Main {
    public static void main(String[] args) {
        HighArray array = new HighArray(5);

        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);

        System.out.println(array.get(3));
        array.delete(4);
        System.out.println(array);

        OrderedArray test = new OrderedArray(30);

        for (int i = 0; i < test.size(); i++) {
            test.insert(new Random().nextInt(100));
        }

        System.out.println(test);
    }
}
