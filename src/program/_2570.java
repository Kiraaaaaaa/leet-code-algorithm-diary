package program;

import java.util.HashMap;

public class _2570 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}});
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            return null;
        }
    }
}
