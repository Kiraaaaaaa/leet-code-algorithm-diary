package program;

import java.util.Stack;

public class _2917 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKOr(new int[]{22,7,27,30,15,30,28}, 4));
    }
    public static class Solution {
        //还有问题
        public int findKOr(int[] nums, int k) {
            int res = 0;
            if(k == 1){
                for (int num : nums) {
                    res |= num;
                }
                return res;
            }
            for (int i = 0; i < k; i++) {
                int count = 0;
                for (int num : nums) {
                    // if(count == k) break;
                    count += (num >> i) & 1;
                }
                res += count >= k ? Math.pow(2, i) : 0;
            }
            return res;
        }
    }
}
