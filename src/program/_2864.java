package program;

import java.util.Arrays;

public class _2864 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.maximumOddBinaryNumber("1010");
        System.out.println(res);
    }
    public static class Solution{
        //方法1
        public String maximumOddBinaryNumber(String s) {
            int count = 0;
            for (char c : s.toCharArray()) count += c-'0';
            String res = "";
            for (int i = 0; i < count - 1; i++) res += '1';
            for (int i = 0; i < s.length() - count; i++) res += '0';
            return res+"1";
        }
        //方法2，过不了，Long装不下
        public String maximumOddBinaryNumber_1(String s) {
            return "1".repeat(Integer.bitCount(Integer.parseInt(s, 2))-1) + "0".repeat(s.length()-Integer.bitCount(Integer.parseInt(s, 2))) + "1";
        }
    }
}
