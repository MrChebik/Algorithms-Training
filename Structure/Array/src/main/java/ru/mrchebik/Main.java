package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Array array = new Array(5);

        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);

        System.out.println(array.get(3));
        array.deleteValue(4);
        System.out.println(array);
    }
}
