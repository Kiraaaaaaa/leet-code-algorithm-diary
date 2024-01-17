package program;

import java.util.Arrays;

public class _2578 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.splitNum(999999999);
        System.out.println(res);
    }
    public static class Solution {
        public int splitNum(int num) {
            char[] chars = String.valueOf(num).toCharArray();
            Arrays.sort(chars); //先排个序
            int sumA = 0, sumB = 0, N = chars.length;
            for(int i=0; i<N; i+=2){ //奇位坐标的值相加
                sumA = sumA * 10 + (chars[i]-'0');
            }
            for(int i=1; i<N; i+=2){ //偶位坐标的值相加
                sumB = sumB * 10 + (chars[i]-'0');
            }
            return sumA + sumB;
        }
    }
}
