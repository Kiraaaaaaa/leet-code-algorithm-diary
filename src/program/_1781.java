package program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _1781 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.beautySum("aabcb");
        System.out.println(res);
    }
    public static class Solution {
        public int beautySum(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] count = new int[26];
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    count[c-'a']++;
                    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                    for (int k : count) {
                        if(k > 0){
                            max = Math.max(max, k);
                            min = Math.min(min, k);
                        }
                    }
                    res += max - min;
                }
            }
            return res;
        }
    }
}
