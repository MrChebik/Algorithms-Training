package ru.mrchebik;

/**
 * Created by mrchebik on 17.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(100);
        stack.push(1_000);
        stack.push(10_000);
        stack.push(100_000);
        stack.push(1_000_000);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        brackets("a{b[c)d}e");
    }

    /**
     * Example of using Stack,
     * The method will look for matching parentheses
     * @param str String with brackets.
     */
    public static void brackets(String str) {
        Stack stackCharacters = new Stack(str.length());

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch(ch) {
                case '{':
                case '[':
                case '(':
                    stackCharacters.push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!stackCharacters.isEmpty()) {
                        char chx = (char) stackCharacters.pop();
                        if (ch == '}' && chx != '{' ||
                                ch == ']' && chx != '[' ||
                                ch == ')' && chx != '(') {
                            System.out.println("Error " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error " + ch + " at " + i);
                    }
                    break;

                default:
                    break;
            }
        }
        if (!stackCharacters.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
