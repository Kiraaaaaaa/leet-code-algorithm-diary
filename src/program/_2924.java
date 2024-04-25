package program;

import java.util.Arrays;

public class _2924 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.findChampion(2, new int[][]{{1, 0}});
        System.out.println(res);
    }
    static class Solution {
        //方法1.收集所有节点的入度，然后遍历所有节点，找到入度为0的节点，如果大于1则说明不存在冠军
        public int findChampion(int n, int[][] edges) {
            int res = 0;
            int[] map = new int[n];
            for (int[] edge : edges) {
                map[edge[1]] += 1;
            }
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                if(map[i] == 0){
                    count++;
                    res = i;
                }
                if(count == 2) return -1;
            }
            return res;
        }
    }
}
