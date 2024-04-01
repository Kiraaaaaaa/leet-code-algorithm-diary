package program;

import java.util.Arrays;

public class _2580 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.countWays(new int[][]{{6,10},{5,15}});
        System.out.println(res);
    }
    static class Solution {
        public int countWays(int[][] ranges) {
            Arrays.sort(ranges, (a, b) -> a[0] - b[0]); //按照区间左边界排序
            int ans = 1; //方案数
            int maxR = -1; //区间最大值
            for (int[] range : ranges) {
                if(range[0] > maxR){ //当前区间左边界大于区间最大值，说明当前区间可以独立成两个区间
                    ans = ans * 2 % 1_000_000_007; //方案数量*2
                }
                maxR = Math.max(maxR, range[1]); //更新区间最大值
            }
            return ans;
        }
    }
}
