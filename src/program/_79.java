package program;

import java.util.ArrayList;
import java.util.List;

public class _79 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB"));
    }
    public static class Solution {
        boolean res = false;
        int m, n;
        boolean[][] vis; ///记录是否访问过
        int[] dx = new int[]{0, 1, 0, -1}; //X轴方向，在顺时针上的变化
        int[] dy = new int[]{1, 0, -1, 0}; //Y轴方向，在顺时针上的变化
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            vis = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(j, i, board, word, 0); //每一个坐标作为起点开始搜索
                }
            }
            return res;
        }
        private void dfs(int x, int y, char[][] board, String word, int index) {
            if(x < 0 || x >= n || y < 0 || y >= m || //边界超出范围
                    res || //如果找到了就直接返回
                    board[y][x] != word.charAt(index) || //剪枝，如果在匹配的过程中有一个字母不匹配就不用递归了
                    vis[y][x] //不要再次遍历已经走过的点
            ) return;
            if(index == word.length() - 1){ //一定要设置已匹配的字符串长度不能超过目标长度，否则无限循环，例如搜索"ESS"，不限制长度会组成ESSSSSS...也就是说两个连续相同的字符会来回递归
                if(word.charAt(index) == board[y][x]) res = true; //最后一个字符匹配成功
                return;
            }
            vis[y][x] = true; //标记为已访问
            for(int i = 0; i < 4; i++) { //遍历四个方向
                int newX = x + dx[i];
                int newY = y + dy[i];
                dfs(newX, newY, board, word, index+1);
            }
            vis[y][x] = false; //回溯，撤销标记
        }
    }
}
