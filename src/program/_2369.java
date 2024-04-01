package program;

public class _2369 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.validPartition(new int[]{4,4,4,5,6});
        System.out.println(res);
    }
    public static class Solution{
        //动态规划，dp[i]表示nums[0..i]是否可以被拆分
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i < n; i++) {
                if(dp[i-1] && nums[i] == nums[i-1] ||
                        i > 1 && dp[i-2] &&
                                (nums[i] == nums[i-1] && nums[i] == nums[i-2] || nums[i] == nums[i-1] + 1 && nums[i] == nums[i-2] + 2)

                ){
                    dp[i+1] = true;
                }
            }
            return dp[n];
        }
    }
}
