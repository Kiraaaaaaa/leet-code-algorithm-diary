package program;

import java.util.Arrays;

public class _1652 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.decrypt(new int[]{2,4,9,3}, -2);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static class Solution {

        //方法1.暴力取模法
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] res = new int[n];
            if(k == 0){
                Arrays.fill(res, 0);
                return res;
            }
            for (int i = 0; i < code.length; i++) {
                for (int j = 1; j <= Math.abs(k); j++) {
                    res[i] += k > 0 ? code[(i+j)%n] : code[(n+i-j)%n];
                }
            }
            return res;
        }
    }
}
