package ru.mrchebik;

/**
 * Created by mrchebik on 22.03.17.
 */
public class LinkStack {
    private FirstLastList theList;

    public LinkStack() {
        theList = new FirstLastList();
    }

    public void push(int id, double dd) {
        theList.insertFirst(id, dd);
    }

    public String pop() {
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
