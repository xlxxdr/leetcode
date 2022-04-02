package code;

public class _189_Rotate {
	public static void main(String[] args) {
		rotate(new int[]{1,2,3,4,5,6,7},3);
		System.out.println();
		rotate(new int[]{-1,-100,3,99},2);
		System.out.println();
		rotate(new int[]{-1,2},3);
		System.out.println();
		rotate(new int[]{-1},3);
		System.out.println();
		rotate(new int[]{-1},2);
	}

	public static void rotate(int[] nums, int k) {
		if (nums.length == 1){
			return;
		}
		int length = nums.length;
		k = k % length;
		int leftPos = k;
		int rightPos = (length - k) * -1;
		int retNums[] = new int[nums.length];
		for (int i = 0; i < length; i++) {
			if (i < nums.length - k){
				retNums[i + leftPos] = nums[i];
			} else {
				retNums[i + rightPos] = nums[i];
			}
		}
		for (int i = 0; i < retNums.length; i++) {
			nums[i] = retNums[i];
			System.out.print(nums[i] + ",");
		}

	}

}
