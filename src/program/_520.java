package program;

public class _520 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.detectCapitalUse("aAA");
        System.out.println(res);
    }
    public static class Solution {
        //方法1.选取首个字母和第二个字母，然后根据首字母和第二个字母的大小写来判断后续字母的大小写
        public boolean detectCapitalUse(String word) {
            if(word.length() == 1) return true;
            boolean first = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' ? true : false; //true代表大写
            boolean second = word.charAt(1) >= 'A' && word.charAt(1) <= 'Z' ? true : false;
            return helper(word, first, second);
        }
        private boolean helper(String word, boolean first, boolean second) {
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if(c >= 'A' && c <= 'Z' && !first) return false; //如果首字母小写，后面只能是小写
                if (c >= 'A' && c <= 'Z' && first && !second) return false; //首字母大写，第二个字母小写，那么后面只能是小写
                if(c >= 'a' && c <= 'z' && first && second) return false; //首字母大写，第二个字母大写，后面只能是大写
            }
            return true;
        }
    }
}
