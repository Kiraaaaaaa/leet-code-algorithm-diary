package program;

import java.util.HashSet;
import java.util.PriorityQueue;

public class _165 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.compareVersion("1.0.1", "1");
        System.out.println(res);
    }
    public static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] a = version1.split("\\.");
            String[] b = version2.split("\\.");
            for (int i = 0; i < Math.max(a.length, b.length); i++) {
                String s1 = i >= a.length ? "0" : a[i]; //超过长度部分默认为0
                String s2 = i >= b.length ? "0" : b[i]; //超过长度部分默认为0
                int num1 = Integer.valueOf(s1);
                int num2 = Integer.valueOf(s2);
                if(num1 != num2) return num1 > num2 ? 1 : -1;
            }
            return 0;
        }
    }
}
