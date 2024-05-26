package program;

public class _100323 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numberOfPairs(new int[]{12}, new int[]{2,4}, 3);
        System.out.println(res);
    }
    public static class Solution {
        public int numberOfPairs(int[] nums1, int[] nums2, int k) {
            int res = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if(nums1[i] % (nums2[j] * k) == 0) res++;
                }
            }
            return res;
        }
    }
}
