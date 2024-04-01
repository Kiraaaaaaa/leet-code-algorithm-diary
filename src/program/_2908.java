package program;

import java.util.Arrays;

public class _2908 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.minimumSum(new int[]{5,4,8,7,10,2});
        System.out.println(res);
    }
    static class Solution {
        //直接暴力拼三个数
        public int minimumSum(int[] nums) {
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if(nums[i]<nums[j] && nums[j]>nums[k]) max = Math.min(max,nums[i]+nums[j]+nums[k]);
                    }
                }
            }
            return max == Integer.MAX_VALUE ? -1 : max;
        }
    }
}
