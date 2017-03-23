package ru.mrchebik;

/**
 * Created by mrchebik on 23.03.17.
 */
public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void setFirst(Link link) {
        first = link;
    }

    public Link geFirst() {
        return first;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        String output = "";

        Link current = first;
        while (current != null) {
            output += current;
            current = current.next;
        }

        return output + "\n";
    }
}
