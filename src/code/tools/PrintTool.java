package code.tools;

public class PrintTool {

	public static String printArray(int[] nums) {
		StringBuilder sb = new StringBuilder();
		if (nums.length == 0) {
			return "[]";
		}
		sb.append("[");
		for (int i = 0; i < nums.length; i++) {
			if (i != nums.length - 1) {
				sb.append(nums[i]).append(",");
			} else {
				sb.append(nums[i]).append("]");
			}
		}
		return sb.toString();
	}

	public static void printListNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		System.out.println(printArray(new int[] {}));
		System.out.println(printArray(new int[] {1, 2, 3}));
	}
}
