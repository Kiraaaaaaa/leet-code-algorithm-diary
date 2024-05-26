package program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring("dvdf");
        System.out.println(res);
    }
    public static class Solution{

        //方法.set存储当前字符串的字符，如果遇到的字符在set中，则说明当前字符串有重复的字符，则需要移动left指针
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0, maxLen = 0, count = 0;
            HashSet<Character> set = new HashSet<>();
            while(right<s.length()){
                //剪枝：如果剩余待遍历的字符串长度已经低于找到的最大长度，则没有必要继续找了
                if(s.length()-left <= maxLen) break;
                char c = s.charAt(right);
                //如果当前字符串中有重复的字符
                if(set.contains(c)){
                    //则left指针右移
                    ++left;
                    //重置right指针到left
                    right = left;
                    //并释放set中的字符
                    set.clear();
                    //将right位置的字符添加到set
                    set.add(s.charAt(right));
                    //重置当前字符串长度为1
                    count = 1;
                }else{
                    //如果没有重复的字符，则添加right位置的字符到set中
                    set.add(c);
                    //并且得到最大长度
                    maxLen = Math.max(maxLen, ++count);
                }
                //无论如何right都要右移
                ++right;
            }
            return maxLen;
        }
        //方法2：用map存储字符的位置，减少了很多没必要的循环
        public int lengthOfLongestSubstring_1(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0, maxLen = 0;
            for (int end = 0; end < s.length(); end++) {
                //当前正在遍历的字符
                char c = s.charAt(end);
                //如果在map中存在该字符，则更新字符串的起始位置为该字符的下一个位置
                if(map.containsKey(c)){
                    start = Math.max(map.get(c)+1, start);
                }
                //更新最大长度
                maxLen = Math.max(maxLen, end-start+1);
                //当前遍历的字符和位置存到map中，如果不存在就是新增，如果存在就是更新
                map.put(c, end);
            }
            return maxLen;
        }
    }
}
