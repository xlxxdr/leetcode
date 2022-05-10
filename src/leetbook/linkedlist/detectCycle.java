package leetbook.linkedlist;

import code.tools.ListNode;

public class detectCycle {

	//[3,2,0,-4]
	// 1
	public static void main(String[] args) {
		detectCycle app = new detectCycle();
		ListNode node1 = new ListNode();
		node1.val = 3;
		node1.next = null;
		ListNode node2 = new ListNode();
		node2.val = 2;
		node2.next = null;
		ListNode node3 = new ListNode();
		node3.val = 0;
		node3.next = null;
		ListNode node4 = new ListNode();
		node4.val = -4;
		node4.next = null;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		ListNode node = app.detectCycle(node1);
		System.out.println("node = " + node);
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		//快慢指针 从同一起点走
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next; //快指针走两步
			slow = slow.next; //慢指针走一步
			if (slow == fast) { //快慢指针相遇,证明有环
				break;
			}
		}

		slow = head;
		//把慢指针再放到头节点，下一次快慢指针相遇的节点即环的入口节点
		while (slow != null && fast != null){
			if(slow == fast) break;
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
