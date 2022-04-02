package code;

import code.tools.ListNode;

public class _876_MiddleNode {

	public static void main(String[] args) {
		ListNode.print(middleNode(ListNode.parseListNodeFromArray(new int[]{1})));
		System.out.println();
		ListNode.print(middleNode(ListNode.parseListNodeFromArray(new int[]{1,2,3,4,5})));
		System.out.println();
		ListNode.print(middleNode(ListNode.parseListNodeFromArray(new int[]{1,2,3,4,5,6})));
	}

	public static ListNode middleNode(ListNode head) {
		int length = 0;
		ListNode p1 = head;
		ListNode p2 = head;
		while (p2 != null) {
			length++;
			p2 = p2.next;
		}
		int middle = length >> 1 ;
		for (int i = 0; i < middle; i++) {
			p1 = p1.next;
		}
		return p1;
	}

}
