package program;

import java.util.Arrays;

public class _100291 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numberOfSpecialChars("bbB");
        System.out.println(res);
    }
    static class Solution {
        public int numberOfSpecialChars(String word) {
            int res = 0;
            boolean[] low = new boolean[26]; //存小写
            boolean[] up = new boolean[26]; //存大写字母首次出现
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    if(!up[word.charAt(i) - 'a']){ //如果大写字母还没有出现
                        low[word.charAt(i) - 'a'] = true; //记录下小写字母出现过
                    }else{
                        low[word.charAt(i) - 'a'] = false; //大写存在过了，那这小写字母就不是特殊字符
                    }
                } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    if(!up[word.charAt(i) - 'A']){ //如果大写字母是首个出现
                        up[word.charAt(i) - 'A'] = true; //记录大写字母首次出现
                        if(low[word.charAt(i) - 'A']) low[word.charAt(i) - 'A'] = true; //并且小写字母如果在此之前存在，则为特殊字符
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if(low[i] && up[i]) res++;
            }
            return res;
        }
    }
}
