package leecode.stack;

import java.util.Stack;

/**
 * @Author Huang Guojun
 * @Date 2019/7/13
 * @Discription 逆波兰表达式求值
 */
public class EvaluateTheInversePolishExpression {
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        int i = 0;
        stack.add(tokens[i]);
        i++;

        int n1 = 0;
        int n2 = 0;
        while (!stack.empty() && i < tokens.length) {
            String s = tokens[i];
            switch (s) {
                case "+":
                    n1 = Integer.parseInt(stack.pop());
                    n2 = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(n1 + n2));
                    break;
                case "-":
                    n1 = Integer.parseInt(stack.pop());
                    n2 = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(n2 - n1));
                    break;
                case "*":
                    n1 = Integer.parseInt(stack.pop());
                    n2 = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(n1 * n2));
                    break;
                case "/":
                    n1 = Integer.parseInt(stack.pop());
                    n2 = Integer.parseInt(stack.pop());
                    stack.add(String.valueOf(n2 / n1));
                    break;
                default:
                    stack.add(s);
                    break;
            }
            i++;
        }
        String s = stack.pop();
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String[] strings = {"2", "1", "+", "3", "*"};
        int i = evalRPN(strings);
        System.out.println(i);
    }
}
