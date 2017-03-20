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

        System.out.println(trans("A*(B+C)-D/(E+F)"));
        System.out.println(doParse("345+*612+/-"));
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

    /**
     * Example of using Stack.
     * The method will produce condition from infix to postfix entry.
     * @param condition Condition of infix entry.
     */
    private static Stack opStack;
    private static String output;

    public static String trans(String condition) {
        opStack = new Stack(condition.length());
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
            output += (char) opStack.pop();
        }

        return output;
    }

    private static void gotOp(char opThis, int prec1) {
        while (!opStack.isEmpty()) {
            char opTop = (char) opStack.pop();
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
            char chx = (char) opStack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }

    // Calculation of postfix condition

    private static Stack parse;

    public static int doParse(String postfix) {
        parse = new Stack(postfix.length());
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < postfix.length(); j++) {
            ch = postfix.charAt(j);
            if (ch >= '0' && ch <= '9') {
                parse.push((int) (ch - '0'));
            } else {
                num2 = (int) parse.pop();
                num1 = (int) parse.pop();
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
        interAns = (int) parse.pop();

        return interAns;
    }
}
