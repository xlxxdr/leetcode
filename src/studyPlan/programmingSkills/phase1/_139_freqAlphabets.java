package studyPlan.programmingSkills.phase1;

import tools.Asserts;
//给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//
//
// 字符（'a' - 'i'）分别用（'1' - '9'）表示。
// 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
//
//
// 返回映射之后形成的新字符串。
//
// 题目数据保证映射始终唯一。
//
//
//
// 示例 1：
//
//
//输入：s = "10#11#12"
//输出："jkab"
//解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//
//
// 示例 2：
//
//
//输入：s = "1326#"
//输出："acz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 只包含数字（'0'-'9'）和 '#' 字符。
// s 是映射始终存在的有效字符串。
//
// Related Topics 字符串 👍 58 👎 0

public class _139_freqAlphabets extends Asserts {

    public static void main(String[] args) {
        _139_freqAlphabets app = new _139_freqAlphabets();
        equals("abcdefghijklmnopqrstuvwxyz", app.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
        equals("acz", app.freqAlphabets("1326#"));
        equals("a", app.freqAlphabets("1"));
        equals("j", app.freqAlphabets("10#"));
        equals("jkab", app.freqAlphabets("10#11#12"));

    }

    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i + 2 < chars.length) {
                // 如果能往后预读两个字符，就预读
                char next = chars[i + 1];
                if (chars[i + 2] == '#') {
                    // 如果往后的第二个字符是`#`,这个说明是超过10的那种类型，#10
                    char ds = (char) ((c - 48) * 10 + (next - 48) + 96);
                    sb.append(ds);
                    i = i + 2;
                } else {
                    char cc = (char) (c - 49 + 97);
                    sb.append(cc);
                }
            } else {
                char singleC = (char) (c - 49 + 97);
                sb.append(singleC);
            }
        }
        return sb.toString();
    }
}
