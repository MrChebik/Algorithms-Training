package ru.mrchebik.tree234;

/**
 * Created by mrchebik on 26.04.17.
 */
public class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;

        return tempNode;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].data == key) {
                return j;
            }
        }

        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.data;

        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] != null) {
                long itsKey = itemArray[j].data;
                if (newKey < itsKey) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    itemArray[j + 1] = newItem;

                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;

        return 0;
    }

    public DataItem removeItem() {
        DataItem temp = itemArray[--numItems];
        itemArray[numItems] = null;

        return temp;
    }

    @Override
    public String toString() {
        String output = "";
        for (int j = 0; j < numItems; j++) {
            output += itemArray[j];
        }
        return output + "/\n";
    }
}
