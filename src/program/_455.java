package program;

import java.util.Arrays;

public class _455 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        System.out.println(res);
    }
    public static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0, res = 0;
            while(i < g.length && j < s.length){
                if(g[i] <= s[j]){
                    res++;
                    i++;
                }
                j++;
            }
            return res;
        }
    }
}
