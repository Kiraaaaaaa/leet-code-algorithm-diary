package program;

public class _100278 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long re = solution.numberOfRightTriangles(new int[][]{{1,0},{0,0}});
        System.out.println(re);
    }
    public static class Solution {
        public long numberOfRightTriangles(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            long res = 0;
            long[] col_count = new long[n]; //记录每一列有多少个1
            long[] row_count = new long[m]; //记录每一行有多少个1
            for (int i = 0; i < m; i++) { //统计每一行和每一列有多少个1
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1){
                        col_count[j]++;
                        row_count[i]++;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 0) continue;
                    res += (col_count[j]-1) * (row_count[i]-1); //如果当前位置是1，那么可组成三角形数=(当前行的1个数-1) * (当前列的1个数-1)
                }
            }
            return res;
        }
    }
}
