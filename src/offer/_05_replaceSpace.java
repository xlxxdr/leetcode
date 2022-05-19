package offer;


//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
public class _05_replaceSpace {

    public static void main(String[] args) {
        _05_replaceSpace app = new _05_replaceSpace();

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
