package program;

import java.util.Arrays;

public class _100285 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.addedInteger(new int[]{2, 6, 4}, new int[]{9, 7, 5});
        System.out.println(re);
    }
    public static class Solution {
        public int addedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            return nums2[0] - nums1[0];
        }
    }
}
