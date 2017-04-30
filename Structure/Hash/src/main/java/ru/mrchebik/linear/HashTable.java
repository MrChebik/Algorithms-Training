package ru.mrchebik.linear;

/**
 * Created by mrchebik on 30.04.17.
 */
public class HashTable {
    private DataItem[] hashArray;
    private DataItem nonItem;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public int hashFunc(int data) {
        return data % arraySize;
    }

    public void insert(DataItem item) {
        int data = item.getData();
        int hashVal = hashFunc(data);

        while (hashArray[hashVal] != null && hashArray[hashVal].getData() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    }

    public DataItem delete(int data) {
        int hashVal = hashFunc(data);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;

                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }

        return null;
    }

    public DataItem find(int data) {
        int hashVal = hashFunc(data);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }

        return null;
    }

    @Override
    public String toString() {
        String output = "Table: ";
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                output += hashArray[j].getData() + " ";
            } else {
                output += "** ";
            }
        }

        return output + "\n";
    }
}
