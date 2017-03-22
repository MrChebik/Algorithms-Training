package ru.mrchebik;

/**
 * Created by mrchebik on 22.03.17.
 */
public class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    public SortedList(Link[] linkArr) {
        first = null;
        for (int j = 0; j < linkArr.length; j++) {
            insert(linkArr[j]);
        }
    }

    public void insert(int id, double dd) {
        Link newLink = new Link(id, dd);
        Link previous = null;
        Link current = first;

        while (current != null && dd > current.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public void insert(Link link) {
        Link previous = null;
        Link current = first;

        while (current != null && link.dData > current.dData) {
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

    public Link remove() {
        Link temp = first;
        first = first.next;

        return temp;
    }

    public boolean isEmpty() {
        return first == null;
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
