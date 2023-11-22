package 刷题;

public class _80 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }
    public static class Solution {
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            int slow = 2, fast = 2;
            while (fast < len) {
                if (nums[slow - 2] != nums[fast]) {
                    nums[slow++] = nums[fast];
                }
                fast++;
            }
            return slow;
        }
    }
}
