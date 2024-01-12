package program;

import java.util.ArrayDeque;
import java.util.Deque;

public class _994 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
        System.out.println(res);
    }
    public static class Solution {
        public int orangesRotting(int[][] grid) {
            int[] dx = {1, -1, 0, 0}; // 记录行数变化
            int[] dy = {0, 0, 1, -1}; // 记录列数变化
            int fresh = 0; // 新鲜橘子数
            int minites = 0; // 最短时间
            int rows = grid.length; // 总行数
            int cols = grid[0].length; // 总列数
            //存放烂橘子的队列，内容为烂橘子的坐标
            Deque<int[]> queue = new ArrayDeque<>();
            //先遍历数组，统计新鲜橘子数和腐烂橘子
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    //记录下新鲜橘子数
                    if(grid[i][j] == 1){
                        ++fresh;
                    }
                    //如果是腐烂橘子，则将其坐标加入队列
                    if(grid[i][j] == 2){
                        queue.add(new int[]{i, j});
                    }
                }
            }
            //开始遍历队列，直到全部被感染或者队列为空
            while(fresh>0 && !queue.isEmpty()){
                int size = queue.size();
                //由于每分钟多个橘子都要感染一次，所以要一起出队列，size是动态的，所以要提取出来。代表这是一轮即将感染其它橘子的橘子
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll(); //得到烂橘子坐标
                    //此烂橘子开始向四周扩散一格
                    for (int k = 0; k < 4; k++) {
                        int x = poll[0] + dx[k];
                        int y = poll[1] + dy[k];
                        //如果在数组范围内，并且是新鲜橘子，则将其置为腐烂橘子
                        if(x>=0 && x<rows && y>=0 && y<cols && grid[x][y] == 1){
                            grid[x][y] = 2;
                            queue.add(new int[]{x, y}); //将此烂橘子加入队列
                            --fresh;
                        }
                    }
                }
                ++minites;
            }
            return fresh <= 0 ? minites : -1;
        }
    }
}
