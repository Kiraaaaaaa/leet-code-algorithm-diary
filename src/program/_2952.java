package program;

import java.util.Arrays;

public class _2952 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.minimumAddedCoins(new int[]{1,4,10}, 19);
        System.out.println(res);
    }
    static class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            int ans = 0; // 答案(需要新增的数)
            int value = 1; // 根据数组前面的数，当前能凑出的数值
            int len = coins.length;
            int i = 0; // 遍历数组的指针
            while(value <= target){ //只要凑不出目标值，就一直继续
                if(i < len && value >= coins[i]){ //如果凑出的数值大于等于当前的数，那么就加上当前数
                    value += coins[i++];
                }else{ //如果凑出的数值大于当前的数，那么说明需要添加新数
                    value *= 2;
                    ans++;
                }
            }
            return ans;
        }
    }
}
