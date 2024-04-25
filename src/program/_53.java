package program;

public class _53 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxSubArray(new int[]{-2});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.前缀和，只需要遍历一遍，用当前位置前缀和减去之前最小的前缀和，那么他们之间的数最大
        public int maxSubArray(int[] nums) {
            int min = 0, res = Integer.MIN_VALUE, sum = 0; //最小前缀和，子数组和，目前前缀和
            for (int num : nums) {
                sum += num; //当前位置的前缀和
                res = Math.max(sum - min, res); //当前位置前缀和减去之前最小的前缀和
                min = Math.min(sum, min); //更新最小前缀和
            }
            return res;
        }
    }
}
