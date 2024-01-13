package program;

import java.util.Arrays;

public class LCR_012 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
    public static class Solution{
        //方法1.比较前后缀和
        public int pivotIndex(int[] nums) {
            int left = 0, right = 0;
            for (int i = 1; i < nums.length; i++)
                right += nums[i]; //先记录除了第一个数以外的值为right总和
            for (int i = 0; i < nums.length; i++) {
                if(left == right) return i; //如果left的值等于right的值，说明找到了，返回第一个数的下标
                left += nums[i];
                if(i != nums.length-1) right -= nums[i+1];
            }
            return -1;
        }
    }
}
