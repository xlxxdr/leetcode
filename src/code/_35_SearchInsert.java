package code;

public class _35_SearchInsert {

	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n - 1; // 定义target在左闭右闭的区间里，[left, right]
		while (left <= right) { // 当left==right，区间[left, right]依然有效
			int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
			if (nums[middle] > target) {
				right = middle - 1; // target 在左区间，所以[left, middle - 1]
			} else if (nums[middle] < target) {
				left = middle + 1; // target 在右区间，所以[middle + 1, right]
			} else { // nums[middle] == target
				return middle;
			}
		}
		return right + 1;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
		System.out.println(searchInsert(new int[] {1}, 0));
		System.out.println(searchInsert(new int[] {1,2,3}, 0));
		System.out.println(searchInsert(new int[] {1,2,3}, 4));
	}
}