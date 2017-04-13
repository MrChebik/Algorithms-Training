import structure.Node;
import structure.TreeHuffman;

import java.util.PriorityQueue;

/**
 * Created by mrchebik on 13.04.17.
 */
public class Main {
    private static String str = "SUSIE SAYS IT IS EASY\n";
    private static char[] ch = new char[str.length()];
    private static int[] colElems = new int[str.length()];
    private static TreeHuffman tree = null;
    private static PriorityQueue<TreeHuffman> priorityQueue = new PriorityQueue<TreeHuffman>();
    private static int nElems = 0;

    public static void main(String[] args) {
        setupCh();
        setupPriorityQueue();
        setupTree();

        // System.out.println(tree);
        // System.out.println(tree.codes);

        System.out.println("Default:  " + str + "\nEncoding: " + tree.setLine() + "\nDecoding: " + tree.decoding(priorityQueue.peek()));
    }

    private static void setupCh() {
        int temp;

        for (int i = 0; i < str.length(); i++) {
            temp = 0;
            for (int j = 0; j <= nElems; j++) {
                if (str.charAt(i) == ch[j]) {
                    temp = 1;
                }
            }
            if (temp != 1) {
                ch[nElems++] = str.charAt(i);
            }
        }
    }

    private static void setupPriorityQueue() {
        for (int i = 0; i < nElems; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (ch[i] == str.charAt(j)) {
                    colElems[i]++;
                }
            }

            priorityQueue.add(new TreeHuffman(new Node(colElems[i], ch[i])));
        }
    }

    private static void setupTree() {
        while (priorityQueue.size() != 1) {
            tree = new TreeHuffman(priorityQueue.remove(), priorityQueue.remove());
            priorityQueue.add(tree);
        }

        tree.setLineStandart(str);
        tree.find(priorityQueue.peek().root, "");
    }
}
