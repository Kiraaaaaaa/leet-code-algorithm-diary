package program;

public class _961 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4});
        System.out.println(res);
    }
    public static class Solution {
        public int repeatedNTimes(int[] nums) {
            int[] count = new int[10001];
            for (int num : nums) {
                if(++count[num] == nums.length/2) return num;
            }
            return -1;
        }
    }
}
