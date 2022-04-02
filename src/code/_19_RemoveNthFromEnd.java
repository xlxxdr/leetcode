package code;

import code.tools.ListNode;

public class _19_RemoveNthFromEnd {

	public static void main(String[] args) {
		// ListNode.print(removeNthFromEnd(ListNode.parseListNodeFromArray(new int[] {1, 2, 3, 4}), 2));
		// System.out.println();
		ListNode.print(removeNthFromEnd(ListNode.parseListNodeFromArray(new int[] {1, 2, 3, 4, 5}), 2));
		System.out.println();
		// ListNode.print(removeNthFromEnd(ListNode.parseListNodeFromArray(new int[] {1}), 1));
		// System.out.println();
		// ListNode.print(removeNthFromEnd(ListNode.parseListNodeFromArray(new int[] {1, 2}), 1));
		// System.out.println();
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 0) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		int flag = 0;
		while (p2 != null) {
			p2 = p2.next;
			if (flag == n) {
				p1 = p1.next;
			}
			flag++;
		}
		if (flag < n){

		}
		if (p1 != null && p1.next != null) {
			p1.next = p1.next.next;
		} else {
			return head.next;
		}
		return head;
	}

}
