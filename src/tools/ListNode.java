package tools;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
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
		StringBuilder sb = new StringBuilder("ListNode[");
		while (node != null) {
			sb.append(node.val);
			if (node.next !=null){
				sb.append(",");
			}
			node = node.next;
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	@Override
	public String toString() {
		return "ListNode{" +
			"val=" + val +"}";
	}

	public static void main(String[] args) {
		ListNode node = parseListNodeFromArray(new int[] {1, 2, 3, 4, 5});
		print(node);
	}
}
