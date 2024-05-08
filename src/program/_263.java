package program;

import java.util.HashMap;

public class _263 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isUgly(14);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.不断整除2,3,5
        public boolean isUgly(int n) {
            if(n < 1) return false;
            int[] nums = {2, 3, 5};
            for (int num : nums) {
                while(n%num == 0) n/=num;
            }
            return n == 1;
        }
    }
}
