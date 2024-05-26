package program;

public class _100296 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findPermutationDifference( "abcde",  "edbac");
        System.out.println(res);
    }
    public static class Solution {

        //方法1.两个字母表分别存储各自出现坐标，遍历两个字母表减去各自差值然后相加即可
        public int findPermutationDifference(String s, String t) {
            int res = 0;
            int[] a = new int[26];
            int[] b = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                char c1 = t.charAt(i);
                a[c-'a'] = i;
                b[c1-'a'] = i;
            }
            for (int i = 0; i < a.length; i++) {
                res += Math.abs(a[i] - b[i]);
            }
            return res;
        }
    }
}
