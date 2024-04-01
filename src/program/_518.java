package program;

import java.util.Arrays;
import java.util.HashMap;

public class _518 {
    public static void main(String[] args) {
        Solution_1 so = new Solution_1();
        int res = so.change(500, new int[]{3,5,7,8,9,10,11});
        System.out.println(res);
    }
    //方法1.个人写的，没有记忆化，超时
    static class Solution {
        int res;
        public int change(int amount, int[] coins) {
            dfs(coins, amount, 0);
            return res;
        }
        private void dfs(int[] coins, int amount, int index) {
            if(amount == 0){
                res += 1;
                return;
            }
            if(amount < 0) return;
            for (int i = index; i < coins.length; i++) {
                dfs(coins,amount - coins[i], i);
            }
            return;
        }
    }
    //方法2.从后往前dfs，根据选择当前硬币，或者不选当前硬币递归下去，将硬币和其剩余金额缓存，避免重复计算
    static class Solution_1 {
        private int[] coins;
        private int[][] memo;

        public int change(int amount, int[] coins) {
            this.coins = coins;
            int n = coins.length;
            memo = new int[n][amount + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1); // -1 表示没有访问过
            }
            return dfs(n - 1, amount); // 从后往前开始搜索
        }

        private int dfs(int i, int c) {
            if (i < 0) {
                return c == 0 ? 1 : 0; //如果数组已遍历完，并且当前金额等于0，返回1，否则返回0
            }
            if (memo[i][c] != -1) { // 之前算过了，返回当前位置和当前金额对应的结果
                return memo[i][c];
            }
            if (c < coins[i]) {
                return memo[i][c] = dfs(i - 1, c); //如果当前金额小于当前硬币的面值，则只能不选当前硬币
            }
            return memo[i][c] = dfs(i - 1, c) + dfs(i, c - coins[i]); //递归下去，结果 = 选择当前位置的结果 + 不选择当前位置的结果
        }
    }
}
