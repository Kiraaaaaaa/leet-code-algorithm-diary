package program;

public class _2643 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.rowAndMaximumOnes(new int[][]{{0, 0, 0}, {0, 1, 1}});
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static class Solution {
        public int[] rowAndMaximumOnes(int[][] mat) {
            int[] res = new int[2];
            for (int i = 0; i < mat.length; i++) {
                int count = 0;
                for (int j = 0; j < mat[i].length; j++) {
                    if(mat[i][j] == 1 && ++count > res[1]){
                        res[0] = i;
                        res[1] = count;
                    }
                }
            }
            return res;
        }
    }
}
