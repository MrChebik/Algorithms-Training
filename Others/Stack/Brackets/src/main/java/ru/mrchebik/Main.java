package ru.mrchebik;

import java.util.Stack;

/**
 * Created by mrchebik on 01.04.17.
 */
public class Main {
    public static void main(String[] args) {
        brackets("a[b{c(d)e}f)g");
    }

    public static void brackets(String str) {
        Stack<Character> stackCharacters = new Stack<Character>();

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
                        char chx = stackCharacters.pop();
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
