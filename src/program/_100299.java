package program;

public class _100299 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.satisfiesConditions(new int[][]{{1, 0, 2}, {1, 0, 2}});
        System.out.println(res);
    }
    public static class Solution {
        public boolean satisfiesConditions(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(j != 0 && grid[i][j] == grid[i][j-1]) return false; //每一行的数只需要和其前一个数比较即可
                    if(grid[0][j] != grid[i][j]) return false; //每一列下面的数只需要和其第一行的数比较即可
                }
            }
            return true;
        }
    }
}
