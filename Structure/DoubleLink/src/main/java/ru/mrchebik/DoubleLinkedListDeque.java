package ru.mrchebik;

/**
 * Created by mrchebik on 26.03.17.
 */
public class DoubleLinkedListDeque {
    private DoubleLink first;
    private DoubleLink last;
    private DoubleLink separator;

    public DoubleLinkedListDeque() {
        first = null;
        last = null;
        separator = new DoubleLink(-1);
    }

    public void insertStack(int data) {
        DoubleLink link = new DoubleLink(data);
        if (first == null) {
            link.next = separator;
            separator.previous = link;
        } else {
            link.next = first;
            first.previous = link;
        }
        first = link;
    }

    public void insertQueue(long data) {
        DoubleLink link = new DoubleLink(data);
        if (last == null) {
            link.previous = separator;
            separator.next = link;
        } else {
            last.next = link;
            link.previous = last;
        }
        last = link;
    }

    public long deleteStack() {
        long temp = first.dData;
        first = first.next;
        first.previous = null;

        return temp;
    }

    public long deleteQueue() {
        long temp = separator.next.dData;
        if (separator.next.next != null) {
            separator.next.next.previous = separator;
            separator.next = separator.next.next;
        } else {
            separator.next = null;
            last = null;
        }

        return temp;

    }

    public DoubleLink peekStack() {
        return first;
    }

    public DoubleLink peekQueue() {
        return separator.next;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public int sizeStack() {
        int temp = 0;
        DoubleLink link = first;
        while (link != separator && link != null) {
            temp++;
            link = link.next;
        }

        return temp;
    }

    public int sizeQueue() {
        int temp = 0;
        DoubleLink link = last;
        while (link != separator && link != null) {
            temp++;
            link = link.previous;
        }

        return temp;
    }

    @Override
    public String toString() {
        String output = "";

        DoubleLink link = first;
        if (link == separator) {
            return "-1";
        } else {
            while (link != null) {
                if (link != separator) {
                    output += link;
                }
                link = link.next;
            }
        }

        return output;
    }
}
