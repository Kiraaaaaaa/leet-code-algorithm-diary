package program;

import java.util.ArrayDeque;
import java.util.HashSet;

public class _921 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minAddToMakeValid(")()");
        System.out.println(res);
    }
    public static class Solution {
        public int minAddToMakeValid(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == '(' && c == ')'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            return stack.size();
        }
    }
}
