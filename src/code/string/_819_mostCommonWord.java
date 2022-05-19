package code.string;

import tools.Asserts;

import java.util.*;

public class _819_mostCommonWord {

    public static void main(String[] args) {
        _819_mostCommonWord app = new _819_mostCommonWord();
        Asserts.equals("b", app.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        Asserts.equals("ball", app.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        paragraph = paragraph.toLowerCase(Locale.ROOT);
        paragraph = paragraph.replaceAll(","," ");
        String[] words = paragraph.split(" ");
        Map<String ,Integer> countMap = new HashMap<>();
        Integer max = Integer.MIN_VALUE;
        String maxWord = null;
        for (String word : words) {
            word = word.replace('!', ' ')
                    .replace('?', ' ')
                    .replace('\'', ' ')
                    .replace(',', ' ')
                    .replace(';', ' ')
                    .replace('.', ' ').trim();
            if (!bannedList.contains(word) && ! word.equals("")){
                if (!countMap.containsKey(word)){
                    if (max < 1){
                        max = 1;
                        maxWord = word;
                    }
                    countMap.put(word,1);
                } else {
                    Integer count = countMap.get(word);
                    count++;
                    if (count > max){
                        max = count;
                        maxWord = word;
                    }
                    countMap.put(word, count + 1);
                }
            }
        }
        return maxWord;
    }
}
