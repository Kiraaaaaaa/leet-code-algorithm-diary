package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1491 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double c = solution.average(new int[]{3000, 1000, 2000});
        System.out.println(c);
    }
    public static class Solution{

        //方法1.最普通的方式
        public double average(int[] salary) {
            int min = salary[0], max = salary[0];
            double res = salary[0];
            int n = salary.length;
            for (int i = 1; i < n; i++) {
                max = Math.max(max, salary[i]);
                min = Math.min(min, salary[i]);
                res += salary[i];
            }
            return (res - min - max) / (double) (n-2);
        }
        //方法2.
        public double average_1(int[] salary) {
            //stream流
            return (double) (Arrays.stream(salary).sum() - Arrays.stream(salary).min().getAsInt() - Arrays.stream(salary).max().getAsInt()) / (salary.length - 2);
        }
    }
}
