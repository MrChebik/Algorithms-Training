package ru.mrchebik;

/**
 * Created by mrchebik on 22.03.17.
 */
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int id, double dd) {
        Link newLink = new Link(id, dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public String deleteFirst() {
        String temp = first.toString();
        if (first.next == null) {
            last = null;
        }
        first = first.next;

        return temp;
    }

    @Override
    public String toString() {
        String output = "";

        Link current = first;
        while (current != null) {
            output += current + " // ";
            current = current.next;
        }

        return output;
    }
}
