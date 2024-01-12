package program;

public class _1572 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int res = solution.diagonalSum_1(arr);
        System.out.println(res);
    }
    public static class Solution{
        //方法1.自己写的枚举
        public int diagonalSum(int[][] mat) {
            int total = 0;
            //左上角和右上角两个坐标
            int[] left = new int[]{0,0}, right = new int[]{0, mat[0].length-1};
            //模拟左上角朝其对角线移动，右上角朝其对角线移动
            while(left[0] < mat.length){
                //先加上左上角对角线的值
                total += mat[left[0]][left[1]];
                if(left[1] != right[1]){
                    total += mat[right[0]][right[1]];
                }
                //两坐标同时移动
                left[0] += 1;
                left[1] += 1;
                right[0] += 1;
                right[1] -= 1;
            }
            return total;
        }
        //方法2.优化枚举
        public int diagonalSum_1(int[][] mat) {
            int N = mat.length, mid = N/2, total = 0;
            for(int i=0; i<N; i++){
                total += mat[i][i] + mat[i][N-i-1];
            }
            return total - mat[mid][mid] * (N&1);
        }
    }
}
