package code.tools;

public class ListNode {

	public int val;
	public ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static ListNode parseListNodeFromArray(int[] nums) {
		ListNode tmpNode = null;
		ListNode headNode = null;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				headNode = new ListNode();
				headNode.val = nums[i];
				headNode.next = null;
				tmpNode = headNode;
			} else {
				ListNode node = new ListNode();
				node.val = nums[i];
				node.next = null;
				tmpNode.next = node;
				tmpNode = node;
			}
		}
		return headNode;
	}

	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		ListNode node = parseListNodeFromArray(new int[] {1, 2, 3, 4, 5});
		print(node);
	}
}
