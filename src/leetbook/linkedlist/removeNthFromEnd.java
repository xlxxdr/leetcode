package leetbook.linkedlist;

import tools.ListNode;

public class removeNthFromEnd {

	public static void main(String[] args) {
		removeNthFromEnd app = new removeNthFromEnd();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
		ListNode.print(head);
		System.out.println();
		ListNode node = app.removeNthFromEnd(head, 3);
		ListNode.print(node);
	}


	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode empty = new ListNode();
		empty.next = head;
		head = empty;
		ListNode slow =  head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast != null){
			fast = fast.next;
			if (fast != null){
				slow = slow.next;
			}
		}
		slow.next = slow.next.next;
		return head.next;
	}

}
