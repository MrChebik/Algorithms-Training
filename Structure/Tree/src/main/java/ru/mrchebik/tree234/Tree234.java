package ru.mrchebik.tree234;

/**
 * Created by mrchebik on 26.04.17.
 */
public class Tree234 {
    private Node root = new Node();

    public int find(long key) {
        Node curNode = root;
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1) {
                return childNumber;
            } else if (curNode.isLeaf()) {
                return -1;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public void insert(long value) {
        Node curNode = root;
        DataItem tempItem = new DataItem(value);

        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();

                curNode = getNextChild(curNode, value);
            } else if (curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode, value);
            }
        }
        curNode.insertItem(tempItem);
    }

    public void split(Node thisNode) {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node newRight = new Node();

        if (thisNode == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public Node getNextChild(Node theNode, long theValue) {
        int j;
        int numItems = theNode.getNumItems();

        for (j = 0; j < numItems; j++) {
            if (theValue < theNode.getItem(j).data) {
                return theNode.getChild(j);
            }
        }

        return theNode.getChild(j);
    }

    public void toStr() {
        recToString(root, 0, 0);
    }

    private void recToString(Node thisNode, int level, int childNumber) {
        System.out.println("level = " + level + " child = " + childNumber + " " + thisNode);

        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recToString(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }
}
