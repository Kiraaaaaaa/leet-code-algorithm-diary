package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LCP_66 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minNumBooths(new String[]{"abc","ab","ac","b"});
        System.out.println(res);
    }
    public static class Solution {
        public int minNumBooths(String[] demand) {
            int[] maxCount = new int[26]; //存储每个字母的最大数量
            int res = 0; //存储最终个数
            for (String s : demand) {
                int[] nowCount = new int[26]; //用来存储当前字符串中每个字母的数量
                for (char c : s.toCharArray()) {
                    int index = c - 'a';
                    ++nowCount[index];
                }
                //如果当前字符串中某个字母的数量大于当前最大数量，则更新该字母的最大数量
                for (int i = 0; i < 26; i++) {
                    maxCount[i] = Math.max(maxCount[i], nowCount[i]);
                }
            }
            for (int i = 0; i < 26; i++) {
                res += maxCount[i]; //统计每个字母的最大数量
            }
            return res;
        }
    }
}
