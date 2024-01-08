package program;

import java.util.ArrayList;
import java.util.HashSet;

public class zero_matri_lcci {
    public static void main(String[] args) {
        int[][] map = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        Solution solution = new Solution();
        solution.setZeroes(map);
        //打印map矩形
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static class Solution{
        public void setZeroes(int[][] matrix) {
            ArrayList<Integer> cols = new ArrayList<>();
            ArrayList<Integer> rows = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(matrix[i][j]==0){
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
            //遍历待修改坐标集合，修改其横坐标
            for (int i = 0; i < rows.size(); i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[rows.get(i)][j] = 0;
                }
            }
            //修改纵坐标
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < cols.size(); j++) {
                    matrix[i][cols.get(j)] = 0;
                }
            }
        }
    }
}
