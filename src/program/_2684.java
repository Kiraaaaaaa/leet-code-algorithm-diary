package program;

public class _2684 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.maxMoves(new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}});
        System.out.println(res);
    }
    public static class Solution{
        int res = 0, n, m; // 分别记录最大步数，网格列数，网格行数
        boolean[][] visited; // 用于记录该坐标是否访问过
        public int maxMoves(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            visited = new boolean[n][m];
            for (int i = 0; i < grid.length; i++) { //从每一行的第一列开始遍历
                dfs(0, i, grid, 0, 0); //参数：当前列，当前行，网格，已走步数，上一步的数字
            }
            return res;
        }
        private void dfs(int x, int y, int[][] grid, int step, int preNum) {
            if(x >= m || y < 0 || y >= n || grid[y][x] <= preNum || visited[y][x]) return; //越界处理 & 避免重复走
            int num = grid[y][x]; //当前位置数字
            res = Math.max(res, step++); //更新最大步数
            visited[y][x] = true; //标记该坐标已访问过
            dfs(x+1, y-1, grid, step, num); //向右上走一步
            dfs(x+1, y, grid, step, num); //向右走一步
            dfs(x+1, y+1, grid, step, num); //向右下走一步
        }
    }
}
