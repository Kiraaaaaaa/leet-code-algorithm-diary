package program;

public class _2908 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,4,8,7,10,2};
        int i = solution.minimumSum(nums);
        System.out.println(i);
    }

    /**
     * 暴力求解，但是数据量一大可能会超时
     */
    public static class Solution{
        public int minimumSum(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if(nums[i] < nums[j] && nums[k] < nums[j]){
                            System.out.println();
                            min = Math.min(min, nums[i]+nums[j]+nums[k]);
                        }
                    }
                }
            }
            return min==Integer.MAX_VALUE?-1:min;
        }
    }
}
