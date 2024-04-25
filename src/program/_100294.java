package program;

public class _100294 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numberOfSpecialChars("bbB");
        System.out.println(res);
    }
    static class Solution {
        public int numberOfSpecialChars(String word) {
            int res = 0;
            boolean[] low = new boolean[26]; //存小写
            boolean[] up = new boolean[26]; //存大写
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    low[word.charAt(i) - 'a'] = true;
                } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    up[word.charAt(i) - 'A'] = true;
                }
            }
            for (int i = 0; i < 26; i++) { //如果该位大小写都有记录，则是特殊值
                if(low[i] && up[i]) res++;
            }
            return res;
        }
    }
}
