package studyPlan.programmingSkills.phase1;

import tools.Asserts;
//给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到
//合并后字符串的末尾。
//
// 返回 合并后的字符串 。
//
//
//
// 示例 1：
//
//
//输入：word1 = "abc", word2 = "pqr"
//输出："apbqcr"
//解释：字符串合并情况如下所示：
//word1：  a   b   c
//word2：    p   q   r
//合并后：  a p b q c r
//
//
// 示例 2：
//
//
//输入：word1 = "ab", word2 = "pqrs"
//输出："apbqrs"
//解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
//word1：  a   b
//word2：    p   q   r   s
//合并后：  a p b q   r   s
//
//
// 示例 3：
//
//
//输入：word1 = "abcd", word2 = "pq"
//输出："apbqcd"
//解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
//word1：  a   b   c   d
//word2：    p   q
//合并后：  a p b q c   d
//
//
//
//
// 提示：
//
//
// 1 <= word1.length, word2.length <= 100
// word1 和 word2 由小写英文字母组成
//
// Related Topics 双指针 字符串 👍 23 👎 0
public class _1768_mergeAlternately extends Asserts {

    public static void main(String[] args) {
        _1768_mergeAlternately app = new _1768_mergeAlternately();
        equals("apbqcr",app.mergeAlternately("abc","pqr"));
        equals("apbqrs",app.mergeAlternately("ab","pqrs"));
        equals("apbqcd",app.mergeAlternately("abcd","pq"));

    }

    public String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        // 定义一个长度等于两个字符串之和的字符数组
        char[] result = new char[word1.length() + word2.length()];
        int minLen = Math.min(chars1.length,chars2.length);
        for (int i = 0; i < minLen; i++) {
            // word1的字符都放在偶数位置
            result[i * 2] = chars1[i];
            // word2的字符都放在奇数位置
            result[i * 2  + 1] = chars2[i];
        }
        if (chars1.length == minLen && chars2.length != minLen){
            for (int i = chars2.length - 1,j = result.length - 1; i >= minLen;i--,j--){
                result[j] = chars2[i];
            }
        }
        if (chars1.length != minLen && chars2.length == minLen){
            for (int i = chars1.length - 1,j = result.length - 1; i >= minLen;i--,j--){
                result[j] = chars1[i];
            }
        }
        return new String(result);
    }
}
