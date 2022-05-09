package code.offer;

import code.tools.Asserts;

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 */
public class _05_ReplaceSpace {

    public static void main(String[] args) {
        _05_ReplaceSpace app = new _05_ReplaceSpace();
        Asserts.equals("We%20are%20happy.",app.replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' '){
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

}
