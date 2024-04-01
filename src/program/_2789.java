package program;

public class _2789 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.maxArrayValue(new int[]{5, 3, 3});
        System.out.println(res);
    }
    public static class Solution{
        // 方法1.倒序遍历，只要涉及递增相加的元素，可以优先考虑倒序，尽可能先合并靠后的数字，使其尽快能大，才能够合并前面的数字
        public long maxArrayValue(int[] nums) {
            long res = nums[nums.length-1];
            for (int i = nums.length-2; i >= 0; i--) {
                res = res >= nums[i] ? res + nums[i] : nums[i];
            }
            return res;
        }
    }
}
