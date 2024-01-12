package program;

import java.util.Arrays;

public class _389 {
    public static void main(String[] args) {
        Solution solution = new Solution();
            char c = solution.findTheDifference("abc", "abcd");
        System.out.println(c);
    }
    public static class Solution{
        public char findTheDifference(String s, String t) {
            int sum1 = 0, sum2 = t.charAt(t.length()-1), sLen = s.length();
            for(int i=0; i<sLen; i++){
                sum1 += s.charAt(i);
                sum2 += t.charAt(i);
            }
            return (char)(sum2-sum1);
        }
    }
}
