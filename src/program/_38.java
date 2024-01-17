package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(7);
        System.out.println(s);
    }
    public static class Solution {
        public String countAndSay(int n) {
            StringBuffer sb = new StringBuffer();
            if(n == 1) return "1";
            String s = countAndSay(n-1); //调用递归函数，在回溯过程中生成字符串
            for (int i = 0; i <= s.length()-1; i++) { //遍历上一层生成的字符串
                if(i == s.length()-1){ //如果该字符串能遍历到最后一位说明最后两位是不相等的, e.g:21
                    sb.append(1).append(s.charAt(i)); //需要添加上最后一位，e.g:1211
                    break; //结束循环
                }
                char now = s.charAt(i); //当前值
                char next = s.charAt(i + 1); //下一个值
                if(now != next){ //如果当前值和下一个值不相等，则添加上当前值
                    sb.append(1).append(now);
                }else{ //如果当前值和下一个值相等
                    int count = 2; //记录当前值出现的次数
                    i++; //当前值右移准备继续判断
                    while(i < s.length()-1 && s.charAt(i) == s.charAt(i + 1)){
                        i++; //只要这两个值相等就继续右移
                        count++; //记录下重复出现的次数
                    }
                    sb.append(count).append(s.charAt(i)); //添加上当前值的出现次数
                }
            }
            return sb.toString();
        }
    }
}
