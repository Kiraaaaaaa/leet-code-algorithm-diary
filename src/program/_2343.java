package program;

import java.io.PrintStream;
import java.util.*;

public class _2343 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.smallestTrimmedNumbers(new String[]{"24","37","96","04"}, new int[][]{{2,1},{2,2}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int n = nums.length;
            int len = nums[0].length();
            int size = queries.length;
            int[] res = new int[size];
            return null;
        }
    }
}
