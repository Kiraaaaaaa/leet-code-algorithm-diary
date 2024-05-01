package program;

import java.util.Arrays;

public class _287 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findDuplicate_1(new int[]{1,3,4,2,2});
        System.out.println(res);
    }
    public static class Solution {
        //要求：不修改数组，额外空间为常量级

        //方法1.双重for遍历（超时）
        public int findDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[i] == nums[j]) return nums[i];
                }
            }
            return 0;
        }

        //方法2.二分查找，不是查数组，而是二分枚举中间值
        public int findDuplicate_1(int[] nums) {
            int len = nums.length; // n + 1 = len, n = len - 1

            // [1..n]代表答案值的集合，枚举每一个答案，然后在数组中遍历出比选取值小的数个数，如果大于当前枚举值
            // 说明答案在左边，否则在右边
            int left = 1; // 开始的数字
            int right = len - 1; // 结束的数字
            while (left < right) { // 出现两次的一定在这个区间
                int mid = (left + right) / 2; // 二分枚举中间值
                int count = 0;
                for (int num : nums) {
                    if(num <= mid){
                        count++; // 遍历原数组找出比选取值小的数个数
                    }
                }
                if(count > mid){ // 如果小于枚举的数的个数大于这个枚举数，出现两次数则一定在左边。
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
