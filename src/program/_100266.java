package program;

public class _100266 {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.countAlternatingSubarrays(new int[]{1,0,0,1});
        System.out.println(res);
    }
    static class Solution {
        //方法1.动态规划
        public long countAlternatingSubarrays(int[] nums) {
            int count = 2, n = nums.length; //count变量用于记录在连续的不同状态下的递增值，初始为2，如果遇到相同值，则count重置为2
            int[] dp = new int[n];
            dp[0] = 1; //第一位包含他自身，所以初始化为1
            for (int i = 1; i < n; i++) {
                if(nums[i] != nums[i-1]){ //如果当前值和前一个值不同
                    dp[i] = dp[i-1] + count++; //那么连续子字符串的个数+count，然后count+1
                }else{ //如果两两相同，则count重置为2，连续子字符串的个数+1，表示只包含它自身
                    count = 2;
                    dp[i] = dp[i-1] + 1;
                }
            }
            return dp[n-1];
        }
        //方法2.更简洁的动态规划
        public long countAlternatingSubarrays_1(int[] nums) {
            int cnt = 0, ans = 0; //当前连续子序列的个数，答案
            for (int i = 0; i < nums.length; i++) {
                cnt = i > 0 && nums[i] != nums[i-1] ? cnt + 1 : 1; //如果当前值和前一个值不同，则连续子字符串的个数+1，否则重置为1
                ans += cnt;
            }
            return ans;
        }
        //方法4.滑动窗口
        public long countAlternatingSubarrays_3(int[] nums) {
            long ans = 1, left = 0; //left表示滑动窗口的左边界，ans表示答案
            for (int i = 1; i < nums.length; i++) { //i表示滑动窗口的右边界
                if(nums[i] != nums[i-1]) ans += i - left + 1;
                else { //如果相同，则当前子数组的个数+1
                    left = i; //更新左边界
                    ans++;
                }
            }
            return ans;
        }
    }
}
