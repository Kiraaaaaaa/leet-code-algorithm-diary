package program;

import java.util.Arrays;

public class _198 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,0,2,1,1,2};
        int rob = solution.rob(arr);
        System.out.println(rob);
    }
    public static class Solution{
        public int rob(int[] nums) {
            int N = nums.length;
            if(N == 0) return 0;
            int[] dp = new int[N + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            //dp[i]代表如果抢了第i个，那么最大能抢到的金额
            //dp[i-1]代表不抢第i个，最大能抢到的金额
            for (int i = 2; i <= N; i++) {
                //分别计算不抢第i个，和抢第i个，返回其中的最大值
                dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
            }
            return dp[N];
        }
    }
}
