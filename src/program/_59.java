package program;

public class _59 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.generateMatrix(10);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int step = 1;
            int[] index = new int[2]; //当前模拟的位置，第一位x轴坐标，第二位为y轴坐标
            //顺时针方向的坐标变化，第一位为x轴坐标，第二位为y轴坐标
            int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
            //当前模拟的方向
            int nowDirection = 0;
            while(step <= Math.pow(n, 2)){
                res[index[1]][index[0]] = step++;
                //到右上角，改变模拟方向朝下
                if((index[0] == n-1 || res[index[1]][index[0]+1] != 0) && nowDirection == 0){
                    nowDirection = 1;
                }
                //到右下角，改变模拟方向朝左
                if((index[1] == n-1 || res[index[1]+1][index[0]] != 0) && nowDirection == 1){
                    nowDirection = 2;
                }
                //到左下角，改变模拟方向朝上
                if((index[0] == 0 || res[index[1]][index[0]-1] != 0) && nowDirection == 2){
                    nowDirection = 3;
                }
                //到左上角， 改变模拟方向朝右
                if((index[1] == 0 || res[index[1]-1][index[0]] != 0) && nowDirection == 3){
                    nowDirection = 0;
                }
                //更新下一步的x轴坐标
                index[0] += direction[nowDirection][0];
                //更新下一步的y轴坐标
                index[1] += direction[nowDirection][1];
            }
            return res;
        }
    }
}
