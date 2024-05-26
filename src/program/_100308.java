package program;

import java.util.HashSet;

public class _100308 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean[] res = solution.isArraySpecial(new int[]{4,3,1,6}, new int[][]{{0,2},{2,3}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static class Solution {
        //方法1.前缀和
        //遍历数组，前缀和记录当前坐标及之前的断点个数，判断两个坐标from与to之间是否有断点判断前缀和是否相等即可
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int n = nums.length;
            int m = queries.length;
            int[] f = new int[n];
            boolean[] res = new boolean[m];
            //遍历数组，前缀和记录当前坐标及之前的断点个数
            for (int i = 1; i < n; i++) {
                f[i] += (nums[i]&1) == (nums[i-1]&1) ? f[i-1]+1 : f[i-1]; //前后两两比较是否相同，相同则该位置断点数量+1
            }
            //遍历查询数组，如果需要判断两个坐标from与to之间是否有断点，判断前缀和是否相等即可
            for (int i = 0, queriesLength = m; i < queriesLength; i++) {
                int[] query = queries[i];
                int from = query[0];
                int to = query[1];
                res[i] = f[from] == f[to];
            }
            return res;
        }
    }
}
