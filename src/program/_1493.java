package program;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _1493 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestSubarray(new int[]{1,1,0,0,1,1,1,0,1});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.遍历出所有0的索引，然后计算每个0的前一个0和后一个0的索引，然后计算两个索引之间的距离，取最大值
        public int longestSubarray(int[] nums) {
            ArrayList<Integer> cache = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) cache.add(i); //首先保存下所有0的坐标
            }
            if(cache.size() == 1 || cache.size() == 0) return nums.length-1; //如果只有一个0或者没有0，那么长度就是整个数组的长度-1
            for (int i = 0; i < cache.size(); i++) {
                int preSum = 0, nextSum = 0; //前一个0到当前0之间的长度，后一个0到当前0之间的长度
                if(i == 0){
                    preSum = cache.get(i); //如果是第一个0，前面的长度就是当前坐标的值
                    nextSum = cache.get(i+1) - cache.get(i) - 1;
                }else if(i == cache.size()-1){
                    preSum = cache.get(i) - cache.get(i-1) - 1;
                    nextSum = nums.length - cache.get(i) - 1; //如果最后一个0，后面长度就是当前坐标到数组末尾的距离
                }else{ //如果0不是第一个也不是最后一个，那么就计算前一个0到当前0之间的长度，后一个0到当前0之间的长度
                    preSum = cache.get(i) - cache.get(i-1) - 1;
                    nextSum = cache.get(i+1) - cache.get(i) - 1;
                }
                max = Math.max(max, preSum + nextSum); //得到最大值
            }
            return max;
        }
    }
}
