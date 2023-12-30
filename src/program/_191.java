package program;

import java.util.Stack;

public class _191 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.hammingWeight(11);
        System.out.println(res);
    }
    public static class Solution {
        public int hammingWeight(int n) {
            if(n == 0) return 0;
            return (n & 1) + hammingWeight(n>>>1);
        }
    }
}
