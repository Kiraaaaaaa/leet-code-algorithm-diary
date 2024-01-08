package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR_014 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "boa"));
    }
    public static class Solution{
        public boolean checkInclusion(String s1, String s2) {
            if(s1.length()>s2.length()) return false;
            int s1Len = s1.length();
            int s2Len = s2.length();

            //用于统计s1中每个字母在滑动区间内出现的次数
            int[] s1Count = new int[26];
            int[] s2Count = new int[26];

            //1.统计第一个区间
            for (int i = 0; i < s1Len; i++) {
                ++s1Count[s1.charAt(i)-'a']; //初始化s1Count
                ++s2Count[s2.charAt(i)-'a']; //每一位字母出现次数+1
            }
            //判断第一个区间是否包含s1
            if(Arrays.equals(s1Count, s2Count)) return true;

            //2.如果不包含s1，滑动窗口开始右移
            for (int i = 0; i < s2Len - s1Len; i++) {
                --s2Count[s2.charAt(i)-'a']; //最左边窗口的字母出现次数-1
                ++s2Count[s2.charAt(i+s1Len)-'a']; //最右边窗口的字母出现次数+1
                if(Arrays.equals(s1Count, s2Count)) return true; //如果其中一次比较结果包含s1，返回true
            }
            return false;
        }
    }
}
