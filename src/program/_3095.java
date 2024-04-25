package program;

public class _3095 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.minimumSubarrayLength(new int[]{2,1,8}, 10);
        System.out.println(res);
    }
    static class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int num = 0;
                for (int j = i; j < nums.length; j++) {
                    num |= nums[j];
                    if(num >= k) res = Math.min(res, j - i + 1);
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
