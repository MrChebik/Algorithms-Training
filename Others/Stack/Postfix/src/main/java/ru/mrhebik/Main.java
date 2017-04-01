package ru.mrhebik;

import java.util.Stack;

/**
 * Created by mrchebik on 01.04.17.
 */
public class Main {
    private static Stack<Character> opStack;
    private static Stack<Integer> parse;
    private static String output;

    public static void main(String[] args) {
        System.out.println(trans("A*(B+C)-D/(E+F)"));
        System.out.println(doParse("345+*612+/-"));
    }

    public static String trans(String condition) {
        opStack = new Stack<Character>();
        output = "";

        for (int j = 0; j < condition.length(); j++) {
            char ch = condition.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOp(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOp(ch, 2);
                    break;
                case '(':
                    opStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output += ch;
                    break;
            }
        }

        while (!opStack.isEmpty()) {
            output += opStack.pop();
        }

        return output;
    }

    private static void gotOp(char opThis, int prec1) {
        while (!opStack.isEmpty()) {
            char opTop = opStack.pop();
            if (opTop == '(') {
                opStack.push(opTop);
                break;
            } else {
                int prec2;
                prec2 = opTop == '+' || opTop == '-' ? 1 : 2;
                if (prec2 < prec1) {
                    opStack.push(opTop);
                    break;
                } else {
                    output += opTop;
                }
            }
        }
        opStack.push(opThis);
    }

    private static void gotParen(char ch) {
        while (!opStack.isEmpty()) {
            char chx = opStack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }

    public static int doParse(String postfix) {
        parse = new Stack<Integer>();
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < postfix.length(); j++) {
            ch = postfix.charAt(j);
            if (ch >= '0' && ch <= '9') {
                parse.push((int) (ch - '0'));
            } else {
                num2 = parse.pop();
                num1 = parse.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                parse.push(interAns);
            }
        }
        interAns = parse.pop();

        return interAns;
    }
}
