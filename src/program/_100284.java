package program;

import java.util.HashMap;

//比赛专用
public class _100284 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isValid("234Adas");
        System.out.println(res);
    }
    public static class Solution {
        public boolean isValid(String word) {
            if(word.length() < 3) return false;
            int i = 0, j = 0; //元音字母、辅音字母出现次数
            for (int l = 0; l < word.length(); l++) {
                char c = word.charAt(l);
                if(Character.isDigit(c)) continue; //跳过数字
                if(!Character.isLetterOrDigit(c)) return false; //是特殊字符返回
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                    i++;
                }else{
                    j++; //要么是元音字母要么是辅音字母
                }
            }
            return i > 0 && j > 0;
        }
    }
}
