package program;

public class _2575 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.divisibilityArray("91221181269244172125025075166510211202115152121212341281327", 21);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public static class Solution {
        public int[] divisibilityArray(String word, int m) {
            int n = word.length();
            int[] res = new int[n];
            long num = 0;
            for (int i = 0; i < n; i++) {
                num = (num * 10 + word.charAt(i)-'0') % m; //注意一定要取模后再赋值，否则会num会数值越界
                res[i] = num == 0 ? 1 : 0;
            }
            return res;
        }
    }
}
