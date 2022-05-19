package studyPlan.programmingSkills.phase1;

import tools.Asserts;

public class _1491_average extends Asserts {

    public static void main(String[] args) {
        _1491_average app = new _1491_average();
        equals(2000.0000, app.average(getIntArray(  1000, 2000,3000)));
        equals(2500.00000, app.average(getIntArray(4000, 3000, 1000, 2000)));

    }

    public double average(int[] salary) {
        if (salary.length < 3) {
            return 0.0;
        }
        // 最大工资
        int max = Integer.MIN_VALUE;
        // 最小工资
        int min = Integer.MAX_VALUE;
        // 总工资
        int sum = 0;
        for (int s : salary) {
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }
            sum += s;
        }
        return (sum - min - max) / (salary.length - 2.0);
    }


}
