package program;

import java.util.Arrays;

public class _441 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.arrangeCoins(2147483647);
        System.out.println(res);
    }
    public static class Solution {
        public int arrangeCoins(int n) {
            int res = 1;
            long sum = 0;
            while(true){
                sum += res;
                if(sum > n) return res-1;
                if(sum == n) return res;
                ++res;
            }
        }
    }
}
