package program;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.searchInsert_1(new int[]{1,3,5,6}, 0);
        System.out.println(re);
    }
    public static class Solution {
        //方法1.逐个比较
        public int searchInsert(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] >= target) return i;
            }
            return nums.length;
        }

        //和方法1同样的方法，换种写法
        public int searchInsert_1(int[] nums, int target) {
            int i = 0;
            while (nums[0] < target && i++ <nums.length-1 && nums[i] < target);
            return i;
        }
        //方法2.二分查找 todo
        public int searchInsert_2(int[] nums, int target) {
            return 0;
        }
    }
}
