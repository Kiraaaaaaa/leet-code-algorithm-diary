package program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _219 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.暴力
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                    if(nums[i] == nums[j]) return true;
                }
            }
            return false;
        }
    }
}
