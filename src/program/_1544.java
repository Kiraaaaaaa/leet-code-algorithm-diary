package program;

import java.util.ArrayDeque;

public class _1544 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.makeGood("bbb");
        System.out.println(res);
    }
    public static class Solution {
        public String makeGood(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            StringBuffer sb = new StringBuffer();
            for (char c : s.toCharArray()) {
                if(!stack.isEmpty() && Math.abs(c-stack.peek()) == 32) stack.pop(); //由于测试用例只包含小写字符，所以这里直接用ASCII码值相减进行比较
                else stack.push(c);
            }
            while(!stack.isEmpty()){
                sb.append(stack.pollLast());
            }
            return sb.toString();
        }
    }
}
