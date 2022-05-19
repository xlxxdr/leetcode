package leetbook.linkedlist;

import java.util.List;

import tools.ListNode;

public class oddEvenList {

	public static void main(String[] args) {
		oddEvenList app = new oddEvenList();
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode oddHead = head;
		ListNode evenHead = head.next;
		while (evenHead != null && evenHead.next != null){
			ListNode target=evenHead.next;
			evenHead.next=evenHead.next.next;
			evenHead=evenHead.next;
			target.next=oddHead.next;
			oddHead.next=target;
			oddHead=oddHead.next;
		}
		return head;
	}

}
