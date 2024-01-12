package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1491 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double c = solution.average(new int[]{3000, 1000, 2000});
        System.out.println(c);
    }
    public static class Solution{
        public double average(int[] salary) {
            int min = salary[0], max = salary[0];
            double res = salary[0];
            for (int i = 1; i < salary.length; i++) {
                max = Math.max(max, salary[i]);
                min = Math.min(min, salary[i]);
                res += salary[i];
                if(i == salary.length-1){
                    res = (res - min - max)/(i-1);
                }
            }
            return res;
        }
    }
}
