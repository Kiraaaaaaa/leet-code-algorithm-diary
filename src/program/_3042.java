package program;

public class _3042 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"});
        System.out.println(res);
    }
    static class Solution {
        public int countPrefixSuffixPairs(String[] words) {
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i+1; j < words.length; j++) {
                    if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])) res++;
                }
            }
            return res;
        }
    }
}
