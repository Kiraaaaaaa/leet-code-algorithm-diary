package program;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class _387 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.firstUniqChar_2("loveleetcode");
        System.out.println(res);
    }
    public static class Solution {
        //方法1.暴力：匹配到另一个字符就将该字符位置标记已被匹配过
        public int firstUniqChar(String s) {
            int n = s.length();
            boolean[] vis = new boolean[n]; //记录已重复数的坐标
            for (int i = 0; i < n; i++) {
                if(vis[i]) continue; //如果是重复数则跳过
                boolean find = false; //是否找到第二个相同的数
                for (int j = i+1; j < n; j++) { //比较该数后面的所有数字
                    if(s.charAt(i) == s.charAt(j)){ //如果重复
                        find = true; //找到
                        vis[j] = true; //标记此数字重复
                    }
                }
                if(!find) return i; //如果没有找到重复的数则返回该数下标
            }
            return -1;
        }

        //方法2.数组计数
        public int firstUniqChar_1(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if(count[s.charAt(i)-'a'] == 1) return i;
            }
            return -1;
        }

        //方法3.map计数，记录字母出现次数，第二次循环字符串，如果遇到只有一次出现次数的就是答案
        public int firstUniqChar_2(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if(map.get(s.charAt(i)) == 1) return i;
            }
            return -1;
        }
    }
}
