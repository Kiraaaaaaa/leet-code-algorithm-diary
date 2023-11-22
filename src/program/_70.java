package program;

public class _70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int b = solution.climbStairs(4);
        int c = solution.climbStairs_2(4);
        System.out.println(c);
    }
    /**
     * 经典的简单动态规划题
     * 由于第N步的走法==N-1的加上N-2的走法
     */
    public static class Solution{
        //使用动态规划的思想，用数组模拟每走一步能有多少种走法
        public int climbStairs(int n) {
            int[] step = new int[47];
            step[0] = 1;
            step[1] = 2;
            for(int i = 2; i < n; i++){
                step[i] = step[i-1] + step[i-2];
            }
            return step[n-1];
        }
        //使用递归来实现，类似于斐波那契数列（超时）
        public int climbStairs_2(int n) {
            if(n==1) return 1;
            if(n==2) return 2;
            return climbStairs_2(n-1)+climbStairs_2(n-2);
        }
    }
}
