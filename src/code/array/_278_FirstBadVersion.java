package code.array;

public class _278_FirstBadVersion {

    public static void main(String[] args) {
        _278_FirstBadVersion app = new _278_FirstBadVersion();

    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int pos = -1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)){
                pos = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
