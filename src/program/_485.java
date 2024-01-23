package program;

public class _485 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(res);
    }
    public static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0, count = 0;
            for (int num : nums) {
                if(num == 0) count = -1;
                max = Math.max(max, ++count);
            }
            return max;
        }
    }
}
