package program;

import java.util.ArrayDeque;

public class _1614 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(res);
    }
    public static class Solution {
        public int maxDepth(String s) {
            int stack = 0, max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '('){
                    stack++;
                    max = Math.max(max, stack);
                }else if(c == ')'){
                    stack--;
                }
            }
            return max;
        }
    }
}
