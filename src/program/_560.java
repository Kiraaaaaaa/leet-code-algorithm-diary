package program;

public class _560 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.subarraySum(new int[]{1,-1,0}, 0);
        System.out.println(res);
    }
    public static class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length, res = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int r = i;
                while (r < n){
                    sum += nums[r++];
                    if(sum == k) res++;
                }
            }
            return res;
        }
    }
}
