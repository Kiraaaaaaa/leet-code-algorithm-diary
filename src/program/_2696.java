package program;

import java.util.ArrayDeque;

public class _2696 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minLength_1("ABFCACDB");
        System.out.println(res);
    }
    public static class Solution{
        //方法1.暴力，使用API
        public int minLength(String s) {
            while(s.contains("AB") || s.contains("CD")){
                s = s.replace("AB", "");
                s = s.replace("CD", "");
            }
            return s.length();
        }
        //方法2.使用栈来存储合法的字母
        public int minLength_1(String s) {
            var stack = new ArrayDeque<Character>();
            for (char c : s.toCharArray()) {
                //如果当前遍历的字符和栈顶元素是不合法的，则出栈不合法的字母
                if(!stack.isEmpty() && (c=='B' && stack.peek()=='A' || c=='D' && stack.peek()=='C')){
                    stack.pop();
                }else{
                    //如果是合法的字母则入栈计数
                    stack.push(c);
                }
            }
            return stack.size();
        }
    }
}
