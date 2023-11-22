package 刷题;

import java.util.Arrays;

public class _274 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{11, 15};
        int i = solution.hIndex(nums);
        System.out.println(i);

    }
    public static class Solution {
        public int hIndex(int[] nums) {
            int len = nums.length;
            //特殊判断只有一位的特殊情况
            if(len==1){
                return nums[0]>=1?1:0;
            }
            //先整个排序，倒着来数大的，你想怎么手写怎么排，我直接调用api
            Arrays.sort(nums);
            int h = 0;
            for (int i = len-1; i >= 0; i--) {
                if(nums[i] > h) h++;
            }
            return h;
        }
    }
}
