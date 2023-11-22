package program;

/**
 * 每天的股价有三种状态，即[谷点]、[上升]、[降低]，但在此题上和原版买卖股票leetcode121不一样的是：
 * 我们可以不停的买卖也就是说[谷点]和[下降]状态是[等同]的
 * [谷点+下降]的时候不仅需要重置最小值，结果值还要加上上一段区间
 * [上升]的时候需要持续不断的更新区间值，但有个[例外]：如果最后一次区间是上升就永远都不会被下一次下降所收回，所以需要额外注意是否为最后一次收集
 */
public class _122 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7,1,5,3,6,4};
        int i = solution.maxProfit_2(nums);
        System.out.println(i);

    }
    public static class Solution {
        public int maxProfit_1(int[] nums) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                //股价上升
                if(nums[i]-min >= max){
                    //如果股价还在上升则更新最大区间
                    max = nums[i]-min;
                    //如果最后一次收集是持续增加的就需要手动收集一次
                    if(i==nums.length-1){
                        result += max;
                    }
                }else{
                    //股价降低

                    //加上上一段区间
                    result += max;
                    //重置区间值，准备重新计数
                    max = 0;
                    //重置最小值，准备重新计数
                    min = nums[i];
                }
            }
            return result==0?max:result;
        }

        /**
         * 贪心解法
         * @param nums
         * @return
         */
        public int maxProfit_2(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] < nums[i+1]) result += nums[i+1] - nums[i];
            }
            return result;
        }
    }
}
