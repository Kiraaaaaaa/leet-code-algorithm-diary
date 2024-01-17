package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.threeSumClosest(new int[]{0, 0, 0}, 1);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.暴力相加
        public int threeSumClosest(int[] nums, int target) {
            //三个for
            int min = Integer.MAX_VALUE, res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int range = Math.abs(nums[i] + nums[j] + nums[k] - target); //计算差值
                        if(range < min){
                            min = range; //更新最新差值
                            res = nums[i] + nums[j] + nums[k]; //更新和
                        }
                    }
                }
            }
            return res;
        }
        //方法2.排序+双指针 todo
        public int threeSumClosest_1(int[] nums, int target) {
            return 0;
        }
    }
}
