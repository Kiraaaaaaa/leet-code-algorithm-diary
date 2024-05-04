package program;

import java.util.Arrays;

public class _34 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.searchRange_1(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static class Solution {

        //方法1.给一个变量first记录第一个位置，second变量只要遇见target就记录位置，这不就找到了嘛？
        public int[] searchRange(int[] nums, int target) {
            int first = -1, second = -1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == target){ //如果找到一个
                    if(first == -1) first = i; //没遇到过则记录到第一个
                    second = i; //另一个遇到就更新
                }
            }
            return first != -1 ? new int[]{first, second} : new int[]{-1, -1};
        }

        //方法2.左闭右开-二分查找
        public int[] searchRange_2(int[] nums, int target) {
            int l = func(nums, target);
            int r = func(nums, target + 1);
            return l == r ? new int[]{-1, -1} : new int[]{l, r - 1};
        }
        private int func(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left < right){
                int mid = (left + right) >>> 1;
                if(target <= nums[mid]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
