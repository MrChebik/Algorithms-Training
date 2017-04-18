package ru.mrchebik;

import ru.mrchebik.redblack.Tree;

/**
 * Created by mrchebik on 15.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        long start = System.nanoTime();

        tree.insert(50);
        tree.insert(75);
        tree.insert(25);
        tree.insert(100);
        tree.insert(70);
        tree.insert(65);
        tree.insert(72);
        tree.insert(12);
        tree.insert(26);
        tree.insert(55);
        tree.insert(67);
        tree.insert(53);
        tree.insert(56);
        tree.insert(66);
        tree.insert(68);

        long end = System.nanoTime();

        System.out.println((end - start) + " ns");

        System.out.println(tree);

        tree.delete();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(6);
        tree.insert(18);

        System.out.println(tree);

        tree.delete();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(31);
        tree.insert(43);

        System.out.println(tree);

        /* Incredible TEST */

        /*for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < 15; i++) {
                tree.insert(new Random().nextInt(99) + 1);
            }
            System.out.println(tree);
            tree.delete();
        }*/

    }
}
