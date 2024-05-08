package program;

import java.util.ArrayDeque;
import java.util.HashMap;

public class _316 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.removeDuplicateLetters("bcabc");
        System.out.println(res);
    }
    public static class Solution {
        //方法1.单调栈（真难懂）
        public String removeDuplicateLetters(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int[] count = new int[26]; //记录字母剩余个数
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }
            boolean[] inStack = new boolean[26]; //记录是否在栈中记录
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                --count[c-'a'];
                if(inStack[c-'a']) continue;
                while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0){
                    inStack[stack.pop()-'a'] = false;
                }
                stack.push(c);
                inStack[c-'a'] = true;
            }
            StringBuilder res = new StringBuilder();
            while(!stack.isEmpty()){
                res.append(stack.pollLast());
            }
            return res.toString();
        }
    }
}
