package program;

import java.util.Arrays;

public class _1738 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.kthLargestValue(new int[][]{{5,2},{1,6}}, 1);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.二维异或前缀和
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] res = new int[m*n]; // 每个坐标得到的异或值
            int[][] s = new int[m + 1][n + 1]; // 二维异或前缀和
            int index = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 当前位置的异或前缀和 = 当前行目前的异或前缀和 ^ 当前列目前的异或前缀和 ^ 左上角交叉的区域(用于还原) ^ 当前位置的值
                    s[i+1][j+1] = s[i+1][j] ^ s[i][j+1] ^ matrix[i][j] ^ s[i][j];
                    res[index++] = s[i+1][j+1];
                }
            }
            Arrays.sort(res);
            return res[index-k];
        }
    }
}
