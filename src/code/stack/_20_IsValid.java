package code.stack;

import tools.Asserts;

import java.util.Stack;


/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
public class _20_IsValid {

    public static void main(String[] args) {
        _20_IsValid app = new _20_IsValid();
        Asserts.isFalse(app.isValid("(){}}{"));
        Asserts.isFalse(app.isValid("){}}{"));
        Asserts.isFalse(app.isValid("){"));
        Asserts.isTrue(app.isValid("()"));
        Asserts.isTrue(app.isValid("()[]{}"));
        Asserts.isFalse(app.isValid("(]"));
        Asserts.isFalse(app.isValid("([)]"));
        Asserts.isTrue(app.isValid("{[]}"));

    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] != '(' && chars[i] != '[' && chars[i] != '{')) {
                return false;
            } else if ((chars[i] == ')' || chars[i] == '}' || chars[i] == ']') && stack.isEmpty()) {
                return false;
            }
            if (chars[i] == ')') {
                if (stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else if (chars[i] == '}') {
                if (stack.peek().equals('{')) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else if (chars[i] == ']') {
                if (stack.peek().equals('[')) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }


}
