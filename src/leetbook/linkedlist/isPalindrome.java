package leetbook.linkedlist;

import tools.Asserts;
import tools.ListNode;

public class isPalindrome {

	public static void main(String[] args) {
		isPalindrome app = new isPalindrome();
		Asserts.isTrue(app.isPalindrome(ListNode.parseListNodeFromArray(new int[] {0, 0})));
		Asserts.isTrue(app.isPalindrome(new ListNode(1)));
		Asserts.isFalse(app.isPalindrome(ListNode.parseListNodeFromArray(new int[] {1, 2})));
		Asserts.isTrue(app.isPalindrome(ListNode.parseListNodeFromArray(new int[] {1, 2, 2, 1})));
		Asserts.isTrue(app.isPalindrome(ListNode.parseListNodeFromArray(new int[] {1, 2, 3, 3, 3, 2, 1})));
		Asserts.isFalse(app.isPalindrome(ListNode.parseListNodeFromArray(new int[] {1, 0, 0})));
		Asserts.isTrue(app.isPalindrome(ListNode.parseListNodeFromArray(new int[] {1, 2, 3, 3, 2, 1})));
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}
		if (head.next == null) {
			return true;
		}
		// 反转部分链表
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode reSlow = null;
		while (fast != null && fast.next != null) {
			ListNode tmp = new ListNode(slow.val);
			tmp.next = reSlow;
			reSlow = tmp;
			if (slow.val == fast.next.val) {
				fast = fast.next;
				break;
			} else if (slow.val == fast.val) {
				break;
			} else {
				slow = slow.next;
				fast = fast.next;
			}
		}
		while (true) {
			if ((reSlow == null && fast != null) || (fast == null && reSlow != null)) {
				return false;
			}
			if (reSlow.val != fast.val) {
				return false;
			} else {
				reSlow = reSlow.next;
				fast = fast.next;
			}
			return true;
		}
	}
}
