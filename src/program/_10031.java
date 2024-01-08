package program;

import java.util.*;

public class _10031 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.missingInteger(new int[]{3,4,5,1,12,14,13});
        System.out.println(res);
    }
    public static class Solution{
        public int missingInteger(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int total = 0;
            total += nums[0];
            for (int num : nums) {
                set.add(num);
            }
            for (int i = 1; i < nums.length && nums[i] == nums[i-1]+1; i++) {
                set.add(nums[i]);
                total += nums[i];
            }
            while(set.contains(total)){
                total++;
            }
            return total;
        }
    }
}
