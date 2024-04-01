package program;

public class _892 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.surfaceArea(new int[][]{{1,0},{5,4}});
        System.out.println(res);
    }
    static class Solution {
        //方法1.两个循环完成横向的接触面积和竖向的接触面积。其中每遍历到一个位置，就先计算这个位置方块的总面积，然后该位置减去上下箱子的接触面积
        //例如在该代码中按照顺序是这样计算[[1,2],[3,4]]的：
        //1.计算1和2的接触面积2.计算1和3的接触面积3.计算3和4的接触面积4.计算2和4的接触面积
        public int surfaceArea(int[][] grid) {
            int n = grid.length;
            int total = 0;
            //由于是NxN的正方形布局，所以横向计算和纵向计算可以复用for循环
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int area = 0; //这两个箱子之间接触的面积
                    int pre = grid[i][j]; //当前选取的横向箱子
                    int next; //挨着的第二个横向箱子
                    // 1.不断累加总面积(先加上这个位置的方块总面积，后面再减)
                    total += pre * 6;
                    // 2.删除上下箱子接触的面积(这里上下不是指纵坐标的方块)
                    total -= pre > 1 ? (pre - 1) * 2 : 0;
                    if(j != n - 1){ //避免越界
                        // 3.删除横坐标箱子之间的面积
                        next = grid[i][j+1];
                        if(pre != 0 && next != 0){ //只要有一个箱子为0，就不存在接触面积
                            area = Math.min(pre, next) * 2;
                        }
                        total -= area; //总面积减去横向两个方块的接触面积
                        area = 0; //由于横向和纵向接触面积共用一个变量，所以一定要记得清零!
                        // 4.删除纵坐标箱子之间的面积
                        pre = grid[j][i]; //当前选取的纵向箱子
                        next = grid[j+1][i]; //挨着的第二个纵向箱子
                        if(pre != 0 && next != 0){ //只要有一个箱子为0，就不存在接触面积
                            area = Math.min(pre, next) * 2;
                        }
                        total -= area;
                    }
                }

            }
            return total;
        }
    }
}
