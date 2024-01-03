package program;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class _28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int index = solution.strStr("ississippi", "issipi");
        System.out.println(index);
    }

    public static class Solution {
        //解法一，双指针暴力法
        public int strStr(String haystack, String needle) {
            //存头字符坐标集合
            ArrayList<Integer> list = new ArrayList<>();
            //头字符
            char startChar = needle.charAt(0);
            for (int i = 0; i < haystack.length(); i++) {
                //将头字符坐标集合存入list
                if(haystack.charAt(i) == startChar) list.add(i);
            }
            for (int i = 0; i < list.size(); i++) {
                //s1指针
                int s1Cur = list.get(i);
                //s2指针
                int s2Cur = 0;
                while(s2Cur<needle.length() && s1Cur<haystack.length()){
                    char s1Char = haystack.charAt(s1Cur);
                    char s2Char = needle.charAt(s2Cur);
                    if(s1Char == s2Char){
                        //如果匹配到了最后一位说明字符串存在
                        if(s2Cur == needle.length()-1) return list.get(i);
                        ++s1Cur; //s1指针向后移动一位
                        ++s2Cur; //s2指针向后移动一位
                        continue;
                    }else{
                        break; //不匹配直接判断下一个头字符
                    }
                }
            }
            return -1;
        }
        //解法2.KMP算法 todo
        public int strStr_1(String haystack, String needle) {
            return 1;
        }
    }
}
