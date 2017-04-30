package ru.mrchebik.doubleHash;

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

    public int hashFunc1(int data) {
        return data % arraySize;
    }

    public int hashFunc2(int data) {
        return 5 - data % 5;
    }

    public void insert(int data, DataItem item) {
        int hashVal = hashFunc1(data);
        int stepSize = hashFunc2(data);

        while (hashArray[hashVal] != null && hashArray[hashVal].getData() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    }

    public DataItem delete(int data) {
        int hashVal = hashFunc1(data);
        int stepSize = hashFunc2(data);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;

                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }

        return null;
    }

    public DataItem find(int data) {
        int hashVal = hashFunc1(data);
        int stepSize = hashFunc2(data);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
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
