package studyPlan.programmingSkills.phase1;

import tools.Asserts;
import tools.ListNode;
//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
// 请你返回该链表所表示数字的 十进制值 。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
//
//
// 示例 2：
//
// 输入：head = [0]
//输出：0
//
//
// 示例 3：
//
// 输入：head = [1]
//输出：1
//
//
// 示例 4：
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
//
//
// 示例 5：
//
// 输入：head = [0,0]
//输出：0
//
//
//
//
// 提示：
//
//
// 链表不为空。
// 链表的结点总数不超过 30。
// 每个结点的值不是 0 就是 1。
//
// Related Topics 链表 数学 👍 118 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
public class _1290_getDecimalValue extends Asserts {

	public static void main(String[] args) {
		_1290_getDecimalValue app = new _1290_getDecimalValue();
		equals(5,app.getDecimalValue(ListNode.parseListNodeFromArray(getIntArray(1,0,1))));
		equals(18880,app.getDecimalValue(ListNode.parseListNodeFromArray(getIntArray("[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]"))));
		equals(0,app.getDecimalValue(ListNode.parseListNodeFromArray(getIntArray("[0]"))));
		equals(1,app.getDecimalValue(ListNode.parseListNodeFromArray(getIntArray("[1]"))));
		equals(0,app.getDecimalValue(ListNode.parseListNodeFromArray(getIntArray("[0,0]"))));

	}


	public int getDecimalValue1(ListNode head) {
		if (head == null)
			return 0;
		int ans = 0;
		while (head != null) {
			ans = (ans << 1) + head.val;
			head = head.next;
		}
		return ans;
	}

	public int getDecimalValue(ListNode head) {
		StringBuffer sb = new StringBuffer();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}
		char[] chars = sb.toString().toCharArray();
		int sum = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == '1') {
				sum += Math.pow(2,chars.length - i -1);
			}
		}
		return sum;
	}

}
