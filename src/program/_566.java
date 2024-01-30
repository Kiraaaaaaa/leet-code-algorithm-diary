package program;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _566 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.matrixReshape(new int[][]{{1, 2},{3,4}}, 2, 4);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static class Solution{
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int row = -1, col = 0; // 新矩阵的行坐标，列坐标
            int[][] res = new int[r][c];
            for (int i = 0; i < mat.length; i++) { // 遍历原数组
                for (int j = 0; j < mat[i].length; j++, col++) { // 每模拟一次添加，列数col就+1，然后通过col来控制是否换行
                    if(row == r - 1 && col == c) return mat; // 如果row已到达新矩阵最大行数，且列数col已经超过了新矩阵的最大列数，则说明原数组还有元素没遍历完，但是新矩阵已经没有空间了，所以返回原矩阵，避免下面数组越界
                    res[row += (col % c == 0 ? 1 : 0)][col %= c] = mat[i][j]; //如果列数col和最大列数取余后是0说明上一行已经满了，该换行了，row+1，col变为取余后的坐标
                }
            }
            return row == r-1 && col == c ? res : mat; // 如果没有提前返回mat，则说明原数组遍历完了，那么还要判断新矩阵满没满：行数row到达了最大行数r-1，且列数col也到达了最大列数c，那么说明新矩阵已经满了，才返回新矩阵
        }
    }
}
