package code.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import code.tools.Asserts;

/*
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
提示：

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
Related Topics
数组
哈希表
双指针
二分查找
排序
 */
public class _350_Intersect {

	public static void main(String[] args) {
		_350_Intersect app = new _350_Intersect();
		Asserts.equals(new int[] {1}, app.intersect(new int[] {1,2}, new int[] {1,1}));
		Asserts.equals(new int[] {4}, app.intersect(new int[] {4}, new int[] {4}));
		Asserts.equals(new int[] {4, 9}, app.intersect(new int[] {4, 9}, new int[] {4, 9}));
		Asserts.equals(new int[] {9, 4}, app.intersect(new int[] {4, 9}, new int[] {9, 4}));
		Asserts.equals(new int[] {4, 9}, app.intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
		Asserts.equals(new int[] {2, 2}, app.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		int n1Len = nums1.length;
		int n2Len = nums2.length;
		boolean n1Flag = false;
		int high = 0;
		int low = 0;
		if (n1Len >= n2Len) {
			high = n1Len;
			low = n2Len;
			n1Flag = true;
		} else {
			high = n2Len;
			low = n1Len;
		}
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < low; i++) {
			int left = 0;
			int right = high - 1;
			int target = -1;
			if (n1Flag) {
				target = nums2[i];
			} else {
				target = nums1[i];
			}
			while (left <= right) {
				int leftVal = -1;
				if (n1Flag) {
					leftVal = nums1[left];
				} else {
					leftVal = nums2[left];
				}
				int rightVal = -1;
				if (n1Flag) {
					rightVal = nums1[right];
				} else {
					rightVal = nums2[right];
				}

				if (leftVal == target) {
					ret.add(target);
					break;
				} else {
					left++;
				}
				if (rightVal == target) {
					ret.add(target);
					break;
				} else {
					right--;
				}
			}
		}
		int[] result = new int[ret.size()];
		int c = 0;
		for (Integer integer : ret) {
			result[c] = integer;
			c++;
		}
		return result;
	}

}
