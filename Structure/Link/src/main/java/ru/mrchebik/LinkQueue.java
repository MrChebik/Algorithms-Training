package ru.mrchebik;

/**
 * Created by mrchebik on 22.03.17.
 */
public class LinkQueue {
    private FirstLastList theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public void insert(int id, double dd) {
        theList.insertLast(id, dd);
    }

    public String remove() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    @Override
    public String toString() {
        return String.valueOf(theList);
    }
}
