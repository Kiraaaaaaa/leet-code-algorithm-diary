package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _1329 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.diagonalSort(new int[][]{{2},{1}});
        Arrays.stream(res).forEach(i->
        {
            Arrays.stream(i).forEach(System.out::print);
            System.out.println();
        });
    }

    public static class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            ArrayList<Integer> list = new ArrayList<>(); // 用来排序的数组
            //1.先以第一行为起点排序
            for (int i = 0; i < n - 1; i++) {
                int x = i;
                int y = 0;
                while(y < m && x < n){
                    int num = mat[y][x];
                    list.add(num); // 将对角线的值添加到数组中等待排序
                    x++;
                    y++;
                }
                Collections.sort(list); // 对对角线排序
                x = i;
                y = 0;
                for (Integer num : list) {
                    mat[y][x] = num; // 将排序后的值赋给矩阵
                    x++;
                    y++;
                }
                list.clear();
            }
            //2.以第一列为起点排序，不包含{0,0}位置
            for (int i = 1; i < m-1; i++) {
                int x = 0;
                int y = i;
                while(y < m && x < n){
                    int num = mat[y][x];
                    list.add(num);
                    x++;
                    y++;
                }
                Collections.sort(list);
                x = 0;
                y = i;
                for (Integer num : list) {
                    mat[y][x] = num;
                    x++;
                    y++;
                }
                list.clear();
            }
            return mat;
        }
    }
}
