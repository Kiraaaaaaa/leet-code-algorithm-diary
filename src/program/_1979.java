package program;

import java.util.Arrays;

public class _1979 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findGCD(new int[]{2,5,6,9,10});
        System.out.println(res);
    }
    public static class Solution {
        public int findGCD(int[] nums) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, res = 1;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            for (int i = 2; i <= min; i++) {
                if(min % i == 0 && max % i == 0) res = i;
            }
            return res;
        }
    }
}
