package program;

public class _2639 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.findColumnWidth(new int[][]{{-15,1,3},{15,7,12},{5,6,-2}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static class Solution {
        public int[] findColumnWidth(int[][] grid) {
            int len = grid[0].length;
            int[] res = new int[len];
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < len; j++) {
                    res[j] = Math.max(String.valueOf(grid[i][j]).length(), res[j]);
                }
            }
            return res;
        }
    }
}
