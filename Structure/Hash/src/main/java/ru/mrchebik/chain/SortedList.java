package ru.mrchebik.chain;

/**
 * Created by mrchebik on 30.04.17.
 */
public class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    public void insert(Link link) {
        int key = link.getData();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getData()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = link;
        } else {
            previous.next = link;
        }

        link.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getData()) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link find(int key) {
        Link current = first;

        while (current != null && current.getData() <= key) {
            if (current.getData() == key) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public String toString() {
        String output = "List (first --> last): ";
        Link current = first;
        while (current != null) {
            output += current;
            current = current.next;
        }

        return output + "\n";
    }
}
