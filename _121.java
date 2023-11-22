package 刷题;

public class _121 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7,1,5,3,6,4};
        int i = solution.maxProfit(nums);
        System.out.println(i);

    }
    public static class Solution {
        public int maxProfit(int[] nums) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                //记录最低价
                if(nums[i]<min){
                    min = nums[i];
                }else if(nums[i]-min > max){
                    //如果找到更大的区间则更新
                    max = nums[i]-min;
                }
            }
            return max;
        }
    }
}
