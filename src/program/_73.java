package program;

import java.util.*;

public class _73 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(arr);
        Arrays.stream(arr).forEach(i->{
            Arrays.stream(i).forEach(j->{
                System.out.print(j+" ");
            });
            System.out.println();
        });
    }
    public static class Solution {
        public void setZeroes(int[][] matrix) {
            //先存储值为0的行和列坐标
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j] == 0){
                        list.add(new ArrayList<>(List.of(i, j)));
                    }
                }
            }
            //开始清0
            for (int i = 0; i < list.size(); i++) {
                //清空行
                row(matrix, list.get(i).get(0));
                //清空列
                column(matrix, list.get(i).get(1));
            }
        }

        private void column(int[][] matrix, Integer col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        private void row(int[][] matrix, Integer row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
    }
}
