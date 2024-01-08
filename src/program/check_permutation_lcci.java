package program;

public class check_permutation_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.CheckPermutation("abc", "cba"));
    }
    public static class Solution{
        public boolean CheckPermutation(String s1, String s2) {
            if(s1.length()!=s2.length()) return false;
            int[] book = new int[128]; //标记出现过的字母
            for (int i = 0; i < s1.length(); i++) {
                ++book[s1.charAt(i)-'a'];
                --book[s2.charAt(i)-'a'];
            }
            for (int i : book) {
                if(i!=0) return false;
            }
            return true;
        }
    }
}
