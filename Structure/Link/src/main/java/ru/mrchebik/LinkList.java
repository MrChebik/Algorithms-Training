package ru.mrchebik;

/**
 * Created by mrchebik on 21.03.17.
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }

        return current;
    }

    public Link delete() {
        Link temp = first;
        first = first.next;

        return temp;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
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
