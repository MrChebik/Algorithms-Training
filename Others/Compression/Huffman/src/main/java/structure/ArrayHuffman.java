package structure;

/**
 * Created by mrchebik on 14.04.17.
 */
public class ArrayHuffman {
    private char[] letters;
    private String[] codes;
    private int nElems;

    public ArrayHuffman(int size) {
        letters = new char[size];
        codes = new String[size];
        nElems = 0;
    }

    public void insert(char letter, String code) {
        letters[nElems] = letter;
        codes[nElems++] = code;
    }

    public String find(char letter) {
        for (int i = 0; i < nElems; i++) {
            if (letters[i] == letter) {
                return codes[i];
            }
        }

        return "-1";
    }

    public char find(String code) {
        for (int i = 0; i < nElems; i++) {
            if (codes[i].equals(code)) {
                return letters[i];
            }
        }

        return '\0';
    }

    public String toString() {
        String output = "";

        for (int i = 0; i < nElems; i++) {
            output += letters[i] + " // " + codes[i] + "\n";
        }

        return output;
    }
}
