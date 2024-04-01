package program;

public class _2255 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.countPrefixes(new String[]{"wh"}, "w");
        System.out.println(res);
    }
    static class Solution {
        public int countPrefixes(String[] words, String s) {
            int res = 0;
            for (String word : words) if(s.startsWith(word)) res++;
            return res;
        }
    }
}
