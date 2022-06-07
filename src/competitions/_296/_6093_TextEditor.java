//package competitions._296;
//
//import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
//import tools.Asserts;
//
//public class _6093_TextEditor extends Asserts {
//
//    public static void main(String[] args) {
//        _6093_TextEditor app = new _6093_TextEditor();
//
//    }
//
//    static class TextEditor {
//
//        private int pos;
//        private char[] chars;
//
//        public TextEditor() {
//
//        }
//
//        public void addText(String text) {
//            int newLen = chars.length + text.length();
//            char[] newChars = new char[newLen];
//            for (int i = 0; i < chars.length; i++) {
//                newChars[i] = chars[i];
//            }
//            char[] textChars = text.toCharArray();
//            for (int i = 0; i < textChars.length; i++) {
//                newChars[chars.length + i] = textChars[i];
//            }
//            this.chars = newChars;
//            pos = chars.length;
//
//        }
//
//        public int deleteText(int k) {
//            if (pos - k > 0) {
//
//                return k;
//            } else {
//                char
//                System.arraycopy();
//                pos = 0;
//                return pos - k;
//            }
//        }
//
//        public String cursorLeft(int k) {
//            String s = sb.toString();
//
//
//        }
//
//        public String cursorRight(int k) {
//            String s = sb.toString();
//            if (pos + k > s.length()) {
//                k = pos;
//                int retLen = Math.min(10,s.length());
//                return s.substring(k - retLen, k);
//            }
//
//        }
//    }
//}
