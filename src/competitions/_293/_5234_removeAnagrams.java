package competitions._293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _5234_removeAnagrams {

    public static void main(String[] args) {
        _5234_removeAnagrams app = new _5234_removeAnagrams();
        System.out.println(app.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
        System.out.println(app.removeAnagrams(new String[]{"a", "b", "a"}));
        System.out.println(app.removeAnagrams(new String[]{"a"}));
        System.out.println(app.removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
        System.out.println(app.removeAnagrams(new String[]{"baba", "abba", "bbaa", "cd", "cd"}));
        System.out.println(app.removeAnagrams(new String[]{"bbaa", "abba", "baba", "cd", "cd"}));
    }

    public List<String> removeAnagrams(String[] words) {
        if (words.length == 1) {
            return Arrays.asList(words);
        }
        List<String> retList = new ArrayList<>();
        for (int i = 0, j = i + 1; i < words.length - 1 && j < words.length; i++, j++) {
            byte[] cur = words[i].getBytes();
            byte[] next = words[j].getBytes();
            Arrays.sort(cur);
            Arrays.sort(next);
            String curWord = new String(cur);
            String nextWord = new String(next);
            if (curWord.equals(nextWord)) {
                if (!retList.contains(words[i])) {
                    retList.add(words[i]);
                }
                i--;
            } else {
                if (i == 0 && !retList.contains(words[i])) {
                    retList.add(words[i]);
                }
                retList.add(words[j]);
                i = j - 1;
            }
        }
        return retList;
    }
}
