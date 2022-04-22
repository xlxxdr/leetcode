package code.string;

import code.tools.Asserts;

/*
一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。

给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。

请你返回单个句子里 单词的最多数目 。

示例 1：

输入：sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
输出：6
解释：
- 第一个句子 "alice and bob love leetcode" 总共有 5 个单词。
- 第二个句子 "i think so too" 总共有 4 个单词。
- 第三个句子 "this is great thanks very much" 总共有 6 个单词。
所以，单个句子中有最多单词数的是第三个句子，总共有 6 个单词。
示例 2：

输入：sentences = ["please wait", "continue to fight", "continue to win"]
输出：3
解释：可能有多个句子有相同单词数。
这个例子中，第二个句子和第三个句子（加粗斜体）有相同数目的单词数。
 */
public class _2114_MostWordsFound {

	public static void main(String[] args) {
		_2114_MostWordsFound app = new _2114_MostWordsFound();
		Asserts.equals(1, app.mostWordsFound(new String[] {"alice"}));
		Asserts.equals(6, app.mostWordsFound(new String[] {"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
		Asserts.equals(3, app.mostWordsFound(new String[] {"please wait", "continue to fight", "continue to win"}));
		Asserts.equals(4, app.mostWordsFound(new String[] {"please please please wait", "continue to fight", "continue to win"}));
	}

	/*
	直接用正则表达式
 */
	public int mostWordsFound(String[] sentences) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < sentences.length; i++) {
			char[] chars = sentences[i].toCharArray();
			int count = 1;
			for (int k = 0; k < chars.length; k++) {
				if (chars[k] == ' ') {
					count++;
				}
			}
			if (count >= max) {
				max = count;
			}
		}
		return max;
	}

	/*
		直接用正则表达式
	 */
	public int mostWordsFound1(String[] sentences) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < sentences.length; i++) {
			if (sentences[i].split(" ").length >= max) {
				max = sentences[i].split(" ").length;
			}
		}
		return max;
	}

}
