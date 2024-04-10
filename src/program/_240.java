    package program;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.List;

    public class _240 {
    public static void main(String[] args) {
        Solution so = new Solution();
        boolean res = so.searchMatrix_1(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5);
        System.out.println(res);
    }
    static class Solution {
        //方法1.没想到吧 暴力能过
        public boolean searchMatrix(int[][] matrix, int target) {
            boolean find = false;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if(anInt == target) find = true;
                }
            }
            return find;
        }
        //方法2.从右上角来看就是一个二叉搜索树
        public boolean searchMatrix_1(int[][] matrix, int target) {
            int n = matrix.length, m = matrix[0].length, x = m - 1, y = 0;
            while(x >= 0 || y < n){
                int now = matrix[y][x]; //当前根节点
                if(now == target) return true; //找到了
                if(matrix[y][x] >= target) x--;
                else y++;
            }
            return false;
        }
    }
}
