package leecode.stack;

import java.util.Stack;

/**
 * @Author Huang Guojun
 * @Date 2019/6/24
 * @Discription 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class IsValid {
    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> characterStacks = new Stack<>();
        for (char c : charArray) {
            if (c == '(') {
                characterStacks.push(')');
            } else if (c == '{') {
                characterStacks.push('}');
            } else if (c == '[') {
                characterStacks.push(']');
            } else if (characterStacks.isEmpty() || characterStacks.pop() != c) {
                return false;
            }
        }
        return characterStacks.isEmpty();

    }


    public static void main(String[] args) {
        String s = "{[]}";
        boolean valid = isValid(s);

    }
}
