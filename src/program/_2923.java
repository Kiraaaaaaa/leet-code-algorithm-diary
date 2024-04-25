package program;

import java.util.regex.Pattern;

public class _2923 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.findChampion(new int[][]{{0, 1}, {0, 0}});
        System.out.println(res);
    }
    static class Solution {
        //方法1.暴力，收集每支队伍各自赢取的次数，然后得到赢取次数最多的那支队伍
        public int findChampion(int[][] grid) {
            int m = grid[0].length, n = grid.length, res = 0, max = 0;
            for (int i = 0; i < n; i++) {
                int count = 0; //记录该队伍击败了多少队伍
                for (int j = 0; j < m; j++) {
                    if(i == j) continue;
                    if(grid[i][j] == 1) count++;
                }
                if(count > max){ //记录赢取次数最多的那支队伍
                    max = count;
                    res = i;
                }
            }
            return res;
        }
        //方法2.查看该队伍是否击败了其他所有队伍。由于是比赛，所以冠军只有一个，如果该队伍在其它所有队伍的比赛记录中为0，则该队伍就是赢家。
        public int findChampion_1(int[][] grid) {
            int m = grid[0].length, n = grid.length;
            for (int i = 0; i < n; i++) {
                boolean win = true; // 假设该队伍击败了其他所有队伍，获得了冠军
                for (int j = 0; j < m; j++) {
                    if(i != j && grid[j][i] == 1){ // 如果该队伍在其它任何队伍记录中为1，则该队伍肯定不是冠军
                        win = false;
                        break;
                    }
                }
                if(win) return i;
            }
            return -1;
        }
    }
    //方法3.上个算法的优化，打擂台机制，类似于冒泡排序，记录较强者
    public int findChampion_2(int[][] grid) {
        int n = grid.length, winner = 0;
        for (int i = 1; i < grid.length; i++) {
            if(grid[i][winner] == 1) winner = i; // 如果该队伍比目前擂台winner强，则更新winner。然后下一次循环去判断是否有更强者
        }
        return winner;
    }
}
