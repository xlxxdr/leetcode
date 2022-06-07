package studyPlan.programmingSkills.phase2;

import tools.Asserts;
//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
//
//
// 示例 2：
//
//
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
//
//
// 示例 3：
//
//
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅有英文字母和空格 ' ' 组成
// s 中至少存在一个单词
//
// Related Topics 字符串 👍 465 👎 0
public class _58_lengthOfLastWord extends Asserts {

    public static void main(String[] args) {
        _58_lengthOfLastWord app = new _58_lengthOfLastWord();
        equals(5,app.lengthOfLastWord("World"));
        equals(5,app.lengthOfLastWord("Hello World"));
        equals(4,app.lengthOfLastWord("   fly me   to   the moon  "));
        equals(6,app.lengthOfLastWord("luffy is still joyboy"));

    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == ' ') {
                if (len == 0) {
                    continue;
                } else {
                    return len;
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
