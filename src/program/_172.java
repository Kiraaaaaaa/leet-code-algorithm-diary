package program;

import java.util.Arrays;

public class _172 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.trailingZeroes(5);
        System.out.println(res);
    }
    public static class Solution {
        public int trailingZeroes(int n) {
            int res = 0;
            while(n > 0){
                res += n/5;
                n /= 5;
            }
            return res;
        }
    }
}
