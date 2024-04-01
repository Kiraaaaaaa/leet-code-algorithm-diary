package program;

import java.util.Arrays;

public class _3090 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.maximumLengthSubstring("bcbbbcba");
        System.out.println(res);
    }
    static class Solution {
        public int maximumLengthSubstring(String s) {
            int ans = 0;
            for (int i = 0; i < s.toCharArray().length; i++) {
                int size = 0;
                int[] count = new int[26];
                for (int j = i; j < s.toCharArray().length; j++) {
                    char c = s.charAt(j);
                    if(count[c-'a'] == 2) break;
                    count[c-'a']++;
                    size++;
                }
                ans = Math.max(ans, size);
            }
            return ans;
        }
    }
}
