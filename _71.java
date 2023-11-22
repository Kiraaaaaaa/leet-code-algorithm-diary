package 刷题;

import java.util.Arrays;
import java.util.Stack;

public class _71 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        String s = solution.simplifyPath("/a/./b/../..////c/");
        System.out.println(s);
    }

    /**
     * 思路
     * 使用split函数将每一层字符串保存到数组中
     * 1.如果某元素是空字符串、两个或多个"/"重复、"."，则此时无需任何操作
     * 2.如果某元素是".."并且栈存在元素就需要出栈代表去往上一级
     * 3.如果元素是正确路径的就入栈
     * 4.最后根据栈出栈顺序元素前面添加"/"即可
     * 5.栈长度为0说明到达根目录
     */
    public static class Solution {
        public String simplifyPath(String path) {
            String[] arr = path.split("/");
            Stack<String> stack = new Stack<>();
            for(String str : arr) {
                if(str.equals("..") && !stack.isEmpty()) stack.pop();
                if(!str.equals(".") && !str.equals("..")&& !str.equals("")) stack.push(str);
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.insert(0,stack.pop());
                sb.insert(0,"/");
            }
            if(sb.length() == 0) sb.append("/");
            return sb.toString();
        }
    }
}
