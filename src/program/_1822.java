package program;

import java.util.Arrays;
import java.util.Collections;

public class _1822 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 5, 0, 2, -3};
        // int res = solution.arraySign(arr);
        // System.out.println(res);
    }
    public static class Solution{
        public int arraySign(int[] nums) {
            int count = 0; //记录负数的个数
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] < 0){
                    count++;
                }
                if(nums[i] == 0) return 0;
            }
            return count%2==0?1:-1;
        }
    }
}
