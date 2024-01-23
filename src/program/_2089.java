package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2089 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.targetIndices(new int[]{1,2,5,2,3}, 4);
        System.out.println(list);
    }
    public static class Solution {
        //方法1.一次遍历不用排序
        public List<Integer> targetIndices(int[] nums, int target) {
            ArrayList<Integer> res = new ArrayList<>();
            int lower = 0, equal = 0; //比target小的个数，和target相等的个数
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] < target) ++lower;
                if(nums[i] == target) ++equal;
            }
            if(equal == 0) return res;
            for (int i = 0; i < equal; i++) {
                res.add(lower++);
            }
            return res;
        }
    }
}
