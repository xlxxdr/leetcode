package studyPlan.algorithms.phase1;

import tools.Asserts;

public class _344_reverseString extends Asserts {

    public static void main(String[] args) {
        _344_reverseString app = new _344_reverseString();

    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
