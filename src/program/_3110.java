package program;

import java.util.*;

public class _3110 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.scoreOfString("hello");
        System.out.println(res);
    }
    static class Solution {
        public int scoreOfString(String s) {
            int res = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                res += Math.abs(s.charAt(i) - s.charAt(i + 1));
            }
            return res;
        }
    }
}
