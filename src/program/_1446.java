    package program;

import java.util.ArrayList;
import java.util.List;

public class _1446 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxPower("");
        System.out.println(res);
    }
    public static class Solution {
        public int maxPower(String s) {
            int max = 0, count = 2;
            for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) != s.charAt(i+1)) count = 1;
                max = Math.max(count++, max);
            }
            return s.length() == 1 ? 1 : max;
        }
    }
}
