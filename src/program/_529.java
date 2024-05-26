package program;

public class _529 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] res = solution.updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
    public static class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            return board;
        }
    }
}
