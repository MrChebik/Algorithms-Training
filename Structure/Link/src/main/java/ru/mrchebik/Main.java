package ru.mrchebik;

/**
 * Created by mrchebik on 21.03.17.
 */
public class Main {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        linkList.insertFirst(1, 16.789);
        linkList.insertFirst(7, 11.789);
        linkList.insertFirst(41, 19.789);
        linkList.insertFirst(43, 15.789);
        linkList.insertFirst(67, 12.789);

        System.out.println(linkList.find(43));

        System.out.println(linkList.delete(7));

        System.out.println(linkList);

        while (!linkList.isEmpty()) {
            System.out.println(linkList.delete());
        }
        System.out.println();

        FirstLastList firstLastList = new FirstLastList();

        firstLastList.insertFirst(22, 123.32);
        firstLastList.insertFirst(232, 432.57);
        firstLastList.insertFirst(43, 100);

        firstLastList.insertLast(23, 123.31);
        firstLastList.insertLast(61, 27.4);
        firstLastList.insertLast(57, 15.7);

        System.out.println(firstLastList);

        firstLastList.deleteFirst();
        firstLastList.deleteFirst();

        System.out.println(firstLastList);
    }
}
