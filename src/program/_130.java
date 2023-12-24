package program;

import java.util.*;
import java.util.stream.Collectors;

public class _130 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solution.solve(board);
        Arrays.stream(board).forEach(System.out::println);

    }
    public static class Solution {
        int n; //y轴
        int m; //x轴
        public void solve(char[][] board) {
            n = board.length;
            m = board[0].length;
            if(n == 0) return;
            //遍历矩形左右两个边界
            for (int i = 0; i < n; i++) {
                //遍历矩形左边的边界
                dfs(board, i, 0);
                //遍历矩形右边的边界
                dfs(board, i, m-1);
            }
            //遍历上下两个边界
            for (int i = 1; i < m-1; i++) {
                //遍历矩形上边的边界
                dfs(board, 0, i);
                //遍历矩形下边的边界
                dfs(board, n-1, i);
            }
            //遍历全图，把O变成X，把标记过的O从A变回O
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 'A'){
                        board[i][j] = 'O'; //还原
                    }else if(board[i][j] == 'O'){
                        board[i][j] = 'X'; //把被包围的O变成X
                    }
                }
            }
        }

        //DFS递归遍历每个与边界的'O'有相连关系的'O'
        private void dfs(char[][] board, int x, int y) {
            //越界处理，如果是X就不处理，只处理为O的
            if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
            board[x][y] = 'A';
            //向右移动一步
            dfs(board, x+1, y);
            //向下移动一步
            dfs(board, x, y+1);
            //向左移动一步
            dfs(board, x-1, y);
            //向上移动一步
            dfs(board, x, y-1);
        }
    }
}
