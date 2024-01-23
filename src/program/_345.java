package program;

public class _345 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.reverseVowels("Aa");
        System.out.println(res);
    }
    public static class Solution {
        //方法1.双指针
        public String reverseVowels(String s) {
            int l = 0, r = s.length() - 1;
            char[] chars = s.toCharArray();
            while(l < r){
                while(l < r && chars[l] != 'a' && chars[l] != 'e' && chars[l] != 'i' && chars[l] != 'o' && chars[l] != 'u' && chars[l] != 'A' && chars[l] != 'E' && chars[l] != 'I' && chars[l] != 'O' && chars[l] != 'U'){
                    ++l;
                }
                while(l < r && chars[r] != 'a' && chars[r] != 'e' && chars[r] != 'i' && chars[r] != 'o' && chars[r] != 'u' && chars[r] != 'A' && chars[r] != 'E' && chars[r] != 'I' && chars[r] != 'O' && chars[r] != 'U'){
                    --r;
                }
                char temp = chars[l];
                chars[l++] = chars[r];
                chars[r--] = temp;
            }
            return String.valueOf(chars);
        }
    }
}
