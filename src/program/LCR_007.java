package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR_007 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
    public static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int left = i+1;
                int right = nums.length-1;
                //去重
                if(i>0 && nums[i] == nums[i-1]) continue;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    //如果该值和左右指针的值为0，则将三个数加入结果集，然后将指针向中间移动，直到指针重合
                    if(sum == 0){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //右指针左移去重
                        while(left < right && nums[right] == nums[right-1]) --right;
                        //左指针右移去重
                        while(left < right && nums[left] == nums[left+1]) ++left;
                        //此时指针还在重复值的最后一位，所以需要移动指针准备判断另外两个数
                        ++left;
                        --right;
                    }else if(sum > 0){
                        //如果和大于0，说明要求的和在左边，需要移动右指针
                        --right;
                    }else{
                        //如果和小于0，说明要求的和在右边，需要移动左指针
                        ++left;
                    }
                }
            }
            return res;
        }
    }
}
