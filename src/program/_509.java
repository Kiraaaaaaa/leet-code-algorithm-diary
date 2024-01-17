package program;

public class _509 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.fib_3(6);
        System.out.println(res);
    }
    public static class Solution {

        //方法1.经典递归
        public int fib(int n) {
            if(n == 0 || n == 1) return n;
            return fib(n-1) + fib(n-2);
        }
        //方法2.带备忘录的递归(优化)
        public int fib_1(int n) {
            if(n == 0 || n == 1) return n;
            //if (memo[n] != 0) return memo[n]; //设置一个memo数组存储n的计算结果，如果有就取出不用继续递归
            return fib(n-1) + fib(n-2);
        }
        //方法3.空间复杂度O(n)的经典动态规划
        public int fib_2(int n) {
            int[] dp = new int[n + 2]; //dp数组存储n的计算结果
            dp[1] = 1;
            for(int i=2; i<dp.length; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
        //方法4.空间复杂度O(1)的经典动态规划
        public int fib_3(int n) {
            if(n == 1 || n == 0) return n;
            int pre = 0, next = 1; //pre记录前一个值，next记录当前值
            for(int i=2; i<=n; i++){
                int temp = next; //先将当前值缓存
                next = pre + next; //当前值变为前一个值+当前值
                pre = temp; //更新前一个值
            }
            return next;
        }
    }
}
