package program;

import java.util.Arrays;
import java.util.List;

public class _322 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.coinChange(new int[]{1,2147483647}, 2);
        System.out.println(res);
    }
    //方法1.记忆化搜索
    static class Solution {
        int[] cache;
        public int coinChange(int[] coins, int amount) {
            cache = new int[amount+1]; //cache[n] 缓存金额n所需最少步数
            return dfs(coins, 0, amount);
        }

        private int dfs(int[] coins, int step, int amount) {
            if(amount == 0) return 0;
            if(amount < 0) return -1;
            if(cache[amount] != 0) return cache[amount];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int n = dfs(coins, step + 1, amount - coins[i]);
                if(n >= 0 && n < min){
                    min = n + 1;
                }
            }
            cache[amount] = min == Integer.MAX_VALUE ? -1 : min;
            return cache[amount];
        }
    }
}
