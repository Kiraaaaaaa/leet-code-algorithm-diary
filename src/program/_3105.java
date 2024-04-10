package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _3105 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.longestMonotonicSubarray(new int[]{1, 1, 1, 1});
        System.out.println(res);
    }
    static class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int asc = 1, desc = 1, max = 1;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] == nums[i-1]){
                    asc = 1;
                    desc = 1;
                    continue;
                }
                if(nums[i] < nums[i-1]) asc = 1;
                else desc = 1;
                max = Math.max(max, nums[i] < nums[i-1] ? ++desc : ++asc);
            }
            return max;
        }
    }
}
