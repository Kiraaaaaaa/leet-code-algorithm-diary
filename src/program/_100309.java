package program;

import java.util.HashSet;

public class _100309 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.duplicateNumbersXOR(new int[]{10,18,7,10,18});
        System.out.println(res);
    }
    public static class Solution {
        public int duplicateNumbersXOR(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int res = 0;
            for (int num : nums) {
                if(set.contains(num)){
                    res ^= num;
                }
            }
            return res;
        }
    }
}
