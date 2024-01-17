package program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _231 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isPowerOfTwo(1073741825);
        System.out.println(res);
    }
    public static class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n!=1 && (n&1) == 1) return false;
            int num = 1;
            while(num < n){
                num *= 2;
            }
            return num == n ? true : false;
        }
    }
}
