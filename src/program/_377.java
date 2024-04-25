package program;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _377 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.combinationSum4(new int[]{1,2,3}, 4);
        System.out.println(res);
    }
    static class Solution {
        //方法1.递推
        public int combinationSum4(int[] nums, int target) {
            int[] f = new int[target + 1];
            f[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int x : nums) {
                    if (x <= i) {
                        f[i] += f[i - x];
                    }
                }
            }
            return f[target];
        }
        //方法2.dfs
        public int combinationSum4_1(int[] nums, int target) {
            int[] memo = new int[target + 1]; //存储对应target的最多方案数
            Arrays.fill(memo, -1); //-1代表没有访问过，如果不设置默认为0的话可能对于某target的方案数就为0，无法判断该target有没有被尝试过
            return dfs(target, nums, memo);
        }

        private int dfs(int target, int[] nums, int[] memo) {
            if(target == 0) return 1; //找到一种方案
            if(memo[target] != -1){
                return memo[target]; //如果已经计算过该target方案数，直接返回
            }
            int res = 0; //当前target的方案数
            for (int num : nums) {
                if(num <= target){ //如果该数字可尝试
                    res += dfs(target - num, nums, memo); //将每一次小方案数量增加到res中
                }
                memo[target] = res;
            }
            return memo[target];
        }
    }



}
