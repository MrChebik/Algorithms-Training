package ru.mrchebik.chain;

/**
 * Created by mrchebik on 30.04.17.
 */
public class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new SortedList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link link) {
        int key = link.getData();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(link);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link link = hashArray[hashVal].find(key);

        return link;
    }

    public String toString() {
        String output = "";
        for (int j = 0; j < arraySize; j++) {
            output += j + ". " + hashArray[j];
        }

        return output;
    }
}
