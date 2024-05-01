package program;

import java.util.Arrays;

public class _2798 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long re = solution.numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4}, 2);
        System.out.println(re);
    }
    public static class Solution {
        public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
            return (int)Arrays.stream(hours).filter(i -> i >= target).count();
        }
    }
}
