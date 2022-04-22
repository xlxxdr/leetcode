package code.array;

import code.tools.Asserts;

/*
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
解释：需要合并 [1,2,3] 和 [2,5,6] 。
合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
解释：需要合并 [1] 和 [] 。
合并结果是 [1] 。
示例 3：

输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
解释：需要合并的数组是 [] 和 [1] 。
合并结果是 [1] 。
注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 */
public class _88_Merge {

	public static void main(String[] args) {
		_88_Merge app = new _88_Merge();
		// nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
		int[] num1 = {1, 2, 3, 0, 0, 0};
		app.merge(num1, 3, new int[] {2, 5, 6}, 3);
		Asserts.equals(new int[] {1, 2, 2, 3, 5, 6}, num1);
		num1 = new int[] {1};
		app.merge(num1, 1, new int[] {}, 0);
		Asserts.equals(new int[] {1}, num1);
		num1 = new int[] {0};
		app.merge(num1, 0, new int[] {1}, 1);
		Asserts.equals(new int[] {1}, num1);

		num1 = new int[] {4, 5, 6, 0, 0, 0};
		app.merge(num1, 3, new int[] {1, 2, 3}, 3);
		Asserts.equals(new int[] {1, 2, 3, 4, 5, 6}, num1);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len = m + n;
		int n1Pos = 0;
		int n2Pos = 0;
		while (n1Pos < len && n2Pos < n) {
			if (nums1[n1Pos] > nums2[n2Pos]) {
				int flag = 1;
				for (int k = n2Pos + 1; k < n; k++) {
					if (nums1[n1Pos] > nums2[n2Pos]) {
						flag++;
					}
				}
				if (flag == 1) {
					int tmp = nums2[n2Pos];
					nums2[n2Pos] = nums1[n1Pos];
					nums1[n1Pos] = tmp;
					n1Pos++;
				} else {
					for (int i = 0; i < flag; i++) {
						int tmp = nums1[n1Pos + i];
						nums1[n1Pos + 1] = nums2[n2Pos + i];
						nums2[n2Pos + i] = tmp;
					}
					n1Pos += flag;
				}
			} else if (nums1[n1Pos] <= nums2[n2Pos]) {
				if (n1Pos >= m) {
					nums1[n1Pos] = nums2[n2Pos];
					n1Pos++;
					n2Pos++;
				} else {
					n1Pos++;
				}
			}
		}
	}
}
