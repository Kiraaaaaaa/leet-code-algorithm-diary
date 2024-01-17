package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _2221 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.triangularSum(new int[]{1,2,3,4,5});
        System.out.println(res);
    }
    public static class Solution {
        public int triangularSum(int[] nums) {
            if(nums.length == 1) return nums[0];
            int[] arr = new int[nums.length-1];
            for (int i = 0; i < nums.length-1; i++) arr[i] = (nums[i]+nums[i+1])%10;
            return triangularSum(arr);
        }
    }
}
