package code.binarysearch;

import tools.Asserts;

public class _1539_findKthPositive {

    public static void main(String[] args) {
        _1539_findKthPositive app = new _1539_findKthPositive();
        Asserts.equals(105, app.findKthPositive(new int[]{2, 3, 4, 7, 11}, 100));
        Asserts.equals(12, app.findKthPositive(new int[]{2, 3, 4, 7, 11}, 7));
        Asserts.equals(1, app.findKthPositive(new int[]{2, 3, 4, 7, 11}, 1));
        Asserts.equals(10, app.findKthPositive(new int[]{2, 3, 4, 7, 11}, 6));
        Asserts.equals(6, app.findKthPositive(new int[]{1, 2, 3, 4}, 2));
        Asserts.equals(9, app.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));

    }

    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        int dPos = 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int midNum = arr[mid];
            int pos = midNum - mid;
            if (pos > k) {
                right = mid;
                dPos = midNum - right;

            } else {
                left = mid + 1;
            }
        }
        if (dPos == 0) {
            return arr[arr.length - 1] + (k - (arr[arr.length - 1] - arr.length));
        }
        return arr[right] - (dPos - k);
    }
}
