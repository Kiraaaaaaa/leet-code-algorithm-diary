package program;

import java.util.Arrays;

public class _31 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,1,5,4,3};
        solution.nextPermutation(arr);
    }
    public static class Solution {
        public void nextPermutation(int[] nums) {
            int max = 0, min = 0, n = nums.length;
            for (int i = 0; i < n; i++) {
                if(nums[i] > nums[max]){
                    if(i == 0) break;
                    max = i;
                    min = i;
                }
                if(nums[i] < nums[min]){
                    min = i;
                }
            }
            if(max == 0){
                for (int i = 0; i < n / 2; i++) {
                    int temp = nums[n-i-1];
                    nums[n-i-1] = nums[0];
                    nums[0] = temp;
                }
            }else{
                if(nums[min] > nums[max-1]){
                    int temp = nums[min];
                    nums[min] = nums[max-1];
                    nums[max-1] = temp;
                }else{
                    int temp = nums[max];
                    nums[max] = nums[max-1];
                    nums[max-1] = temp;
                }

                for (int i = 0; i < ((min - max) % 2 == 0 ? (min - max) / 2 : (min - max) / 2 + 1); i++) {
                    int t = nums[max];
                    nums[max] = nums[min-i];
                    nums[min-i] = t;
                }
            }
            for (int num : nums) {
                System.out.print(num);
            }
        }
    }
}
