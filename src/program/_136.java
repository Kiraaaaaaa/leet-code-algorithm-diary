package program;

public class _136 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.singleNumber(new int[]{4, 1, 2, 1, 2});
        System.out.println(res);
    }
    public static class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }
}
