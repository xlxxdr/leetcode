package studyPlan.programmingSkills.phase1;

import tools.Asserts;
//给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "Hello"
//输出："hello"
//
//
// 示例 2：
//
//
//输入：s = "here"
//输出："here"
//
//
// 示例 3：
//
//
//输入：s = "LOVELY"
//输出："lovely"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 由 ASCII 字符集中的可打印字符组成
//
// Related Topics 字符串 👍 205 👎 0
public class _709_toLowerCase extends Asserts {

    public static void main(String[] args) {
        _709_toLowerCase app = new _709_toLowerCase();
        equals("hello",app.toLowerCase("Hello"));
        equals("here",app.toLowerCase("here"));
        equals("lovely",app.toLowerCase("LOVELY"));

    }

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 'A' && aChar <= 'Z') {
                chars[i] = (char) (aChar + 32);
            }
        }
        return new String(chars);
    }
}
