package program;

import java.util.HashMap;

public class _1953 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.numberOfWeeks(new int[]{5, 2, 1});
        System.out.println(res);
    }
    public static class Solution {
        public long numberOfWeeks(int[] milestones) {
            long max = 0, sum = 0;
            for (int milestone : milestones) {
                if(milestone > max) max = milestone;
                sum += milestone;
            }
            return (sum-max) >= max ? sum : (sum-max) * 2 + 1;
        }
    }
}
