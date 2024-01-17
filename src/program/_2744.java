package program;

import java.util.HashSet;

public class _2744 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumNumberOfStringPairs_1(new String[]{"aa","ab"});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.哈希set
        public int maximumNumberOfStringPairs(String[] words) {
            int res = 0;
            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                if(set.contains(word)) ++res;
                else set.add(new StringBuffer(word).reverse().toString());
            }
            return res;
        }
        //方法2.暴力
        public int maximumNumberOfStringPairs_1(String[] words) {
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                String reverse = new StringBuffer(words[i]).reverse().toString();
                for (int j = i + 1; j < words.length; j++) {
                    if(words[j].equals(reverse)) ++res;
                }
            }
            return res;
        }
    }
}
