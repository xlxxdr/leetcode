package leetbook.linkedlist;

import code.tools.ListNode;

public class hasCycle {

	public static void main(String[] args) {
		hasCycle app = new hasCycle();
	}


	public boolean hasCycle(ListNode head) {
		//快慢指针 从同一起点走
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next !=null){
			fast =fast.next.next; //快指针走两步
			slow = slow.next; //慢指针走一步
			if(slow==fast){ //快慢指针相遇,证明有环
				return true;
			}
		}
		//无环
		return false;
	}
}
