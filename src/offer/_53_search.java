package offer;

import static tools.Asserts.*;

// 统计一个数字在排序数组中出现的次数。
//
// 	
//
// 	示例 1:
//
// 	输入: nums = [5,7,7,8,8,10], target = 8
// 	输出: 2
// 	示例2:
//
// 	输入: nums = [5,7,7,8,8,10], target = 6
// 	输出: 0
// 	
//
// 	提示：
//
// 	0 <= nums.length <= 105
// 	-109<= nums[i]<= 109
// 	nums是一个非递减数组
// 	-109<= target<= 109

public class _53_search {

	public static void main(String[] args) {
		_53_search app = new _53_search();
		System.out.println(app.search(getIntArray(2,2), 2));
		System.out.println(app.search(getIntArray(5, 7, 7, 8, 8, 10), 8));
		System.out.println(app.search(getIntArray(5,7,7,8,8,10), 6));

	}

	public int search(int[] nums, int target) {
		if (nums.length == 1 ){
			if (nums[0] == target){
				return 1;
			} else {
				return 0;
			}
		}
		int left = 0;
		int right = nums.length;
		boolean found = false;
		while (left < right) {
			int mid = left + ((right - left) >> 1);
			if (nums[mid] == target) {
				left = mid + 1;
				found = true;
			}
			if (nums[mid] > target) {
				right = mid;
			}
			if (nums[mid] < target) {
				left = mid + 1;
			}
		}
		if (!found) {
			return 0;
		}
		int rightBound = left - 1;
		int count = 1;
		for (int i = rightBound - 1; i >= 0; i--) {
			if (nums[i] == target) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

}
