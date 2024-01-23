package program;

public class _1470 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.shuffle(new int[]{1,1,2,2}, 2);
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[n * 2];
            int start = 0;
            for (int i = 0; i < n; i++) {
                res[start++] = nums[i];
                res[start++] = nums[i+n];
            }
            return res;
        }
    }
}
