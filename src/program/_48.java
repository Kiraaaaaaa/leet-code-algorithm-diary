package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class _48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arrs = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        solution.rotate(arrs);
        Arrays.stream(arrs).forEach(arr -> {
            Arrays.stream(arr).forEach(item -> System.out.print(item+" "));
            System.out.println();
        });
    }
    public static class Solution{
        /**
         * 思路(暴力)：
         * 先替换四个角，再替换每条边，替换一轮后，四个角向内收缩，得到新的坐标，开启下一轮替换。
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            //总行数
            int rowLen = matrix.length;
            //总列数
            int colLen = matrix[0].length;

            //先得知四个角的坐标
            int[] topLeft =new int[]{0, 0};
            int[] topRight = new int[]{0, colLen-1};
            int[] bottomLeft = new int[]{rowLen-1, 0};
            int[] bottomRight = new int[]{rowLen-1, colLen-1};

            //一共要替换几轮
            for(int i=0; i<matrix[0].length/2; i++){
                //开始一轮替换
                turnRound(matrix, topLeft, topRight, bottomLeft, bottomRight);
                //替换后重置四个角的坐标，代表往里收缩
                topLeft[0]++;
                topLeft[1]++;
                topRight[0]++;
                topRight[1]--;
                bottomLeft[0]--;
                bottomLeft[1]++;
                bottomRight[0]--;
                bottomRight[1]--;
            }
        }

        /**
         * 开启一轮替换
         * @param matrix 原数组(题目要求在原数组上进行修改)
         * @param topLeft 左上角坐标
         * @param topRight 右上角坐标
         * @param bottomLeft 左下角坐标
         * @param bottomRight 右下角坐标
         */
        private void turnRound(int[][] matrix, int[] topLeft, int[] topRight, int[] bottomLeft, int[] bottomRight) {
            //左上角坐标到右上角坐标
            int rightTopTemp = matrix[topRight[0]][topRight[1]];
            matrix[topRight[0]][topRight[1]] = matrix[topLeft[0]][topLeft[1]];
            //右上角坐标到右下角坐标
            int bottomRightTemp = matrix[bottomRight[0]][bottomRight[1]];
            matrix[bottomRight[0]][bottomRight[1]] =rightTopTemp;
            //右下角坐标到左下角坐标
            int bottomLeftTemp = matrix[bottomLeft[0]][bottomLeft[1]];
            matrix[bottomLeft[0]][bottomLeft[1]] = bottomRightTemp;
            //左下角坐标到左上角坐标
            matrix[topLeft[0]][topLeft[1]] = bottomLeftTemp;

            //处理四个角后开始处理四条边，index代表当前处理值的坐标
            //比如在第一轮中的第一行的数字为[1,2,3,4,5]，那么index就为2,3,4的横坐标
            //根据这个index值和当前这一轮替换中的四个角的坐标就可以得出每个边要替换的坐标
            int len = matrix[0].length; //获取矩阵的边长，将用于计算坐标
            for(int index=topLeft[1]+1; index<=topRight[1]-1; index++){
                //上坐标到右坐标
                int rightTemp = matrix[index][topRight[1]];
                matrix[index][topRight[1]] = matrix[topLeft[0]][index];
                //右坐标到下坐标
                int bottemTemp = matrix[bottomRight[0]][len-1-index];
                matrix[bottomRight[0]][len-1-index] = rightTemp;
                //下坐标到左坐标
                int leftTemp = matrix[matrix[0].length-1-index][bottomLeft[1]];
                matrix[len-1-index][bottomLeft[1]] = bottemTemp;
                //左坐标到上坐标
                matrix[topLeft[0]][index] = leftTemp;
            }
        }
    }
}
