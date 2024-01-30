package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _1957 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.makeFancyString("aab");
        System.out.println(res);
    }
    public static class Solution {
        public String makeFancyString(String s) {
            if(s.length() == 1) return s;
            StringBuffer sb = new StringBuffer();
            sb.append(s.charAt(0)); // 先添加第一位
            for (int i = 1; i < s.length()-1; i++) { //从第二位遍历到倒数第二位
                char cur = s.charAt(i);
                if(s.charAt(i-1) == cur && cur == s.charAt(i+1)) continue; //如果当前字母和前后一位都是一样的则先跳过当前字母
                sb.append(cur); //如果不满足三连击则添加该字母
            }
            sb.append(s.charAt(s.length()-1)); // 添加上最后一位
            return sb.toString();
        }
    }
}
