package competitions._294;

import sun.reflect.generics.tree.ArrayTypeSignature;
import tools.Asserts;

import java.util.Arrays;

public class _6075_maximumBags extends Asserts {

    public static void main(String[] args) {
        _6075_maximumBags app = new _6075_maximumBags();
        equals(3, app.maximumBags(getIntArray(2, 3, 4, 5), getIntArray(1, 2, 4, 4), 2));
        equals(3, app.maximumBags(getIntArray(10, 2, 2), getIntArray(2, 2, 0), 100));

    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] extraCapacity = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            extraCapacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(extraCapacity);
        int count = 0;
        for (int i : extraCapacity) {
            if (i == 0) {
                count++;
                continue;
            }
            if (additionalRocks <= 0) {
                continue;
            }
            if (additionalRocks - i >= 0) {
                count++;
                additionalRocks = additionalRocks - i;
            }
        }
        return count;
    }
}
