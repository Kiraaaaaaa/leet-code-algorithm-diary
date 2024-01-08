package program;

import java.util.Arrays;

public class _10035 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.areaOfMaxDiagonal(new int[][]{{9, 3}, {8, 6}});
        System.out.println(res);
    }
    public static class Solution{
        public int areaOfMaxDiagonal(int[][] dimensions) {
            Double maxDiag = 0D; //最大对角线长度
            int maxArea = 0; //最大对角线的最大面积
            for (int i = 0; i < dimensions.length; i++) {
                int width = dimensions[i][0]; //矩形长
                int height = dimensions[i][1]; //矩形宽
                double diago = Math.pow(width * width + height * height, 0.5); //对角线长度
                int area = width * height; //矩形面积
                if(diago > maxDiag){ //如果当前对角线长度大于最大对角线长度，则更新最大对角线长度和最大面积
                    maxDiag = diago;
                    maxArea = area;
                }else if(diago == maxDiag){ //如果当前对角线长度等于最大对角线长度，则更新最大面积
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }
    }
}
