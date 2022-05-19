package code.string;

import tools.Asserts;

/*
统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

请注意，你可以假定字符串里不包括任何不可打印的字符。

示例:

输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
Related Topics
字符串
 */
public class _434_CountSegments {

    public static void main(String[] args) {
        _434_CountSegments app = new _434_CountSegments();
        Asserts.equals(1, app.countSegments(" A "));
        Asserts.equals(1, app.countSegments("Hello,"));
        Asserts.equals(0, app.countSegments(" "));
        Asserts.equals(5, app.countSegments("Hello, my name is John"));
        Asserts.equals(5, app.countSegments("Hello, my name is John "));

    }

    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int wordLen = 0;
        boolean spaceFlag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spaceFlag = true;
                if (wordLen != 0) {
                    count++;
                    wordLen = 0;
                }
            } else {
                wordLen++;
            }
            if ((i == chars.length - 1 && !spaceFlag) || (i == chars.length - 1 && wordLen > 0)) {
                count++;
            }
        }
        return count;

    }

}
