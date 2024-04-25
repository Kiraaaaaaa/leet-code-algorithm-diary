package program;

public class _3115 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumPrimeDifference(new int[]{4,8,2,8});
        System.out.println(res);
    }
    static class Solution {
        public int maximumPrimeDifference(int[] nums) {
            int first = -1, last = -1;
            for (int i = 0; i < nums.length; i++) {
                if(isPrime(nums[i])){
                    if(first == -1) first = i;
                    last = i;
                }
            }
            return last == -1 ? 0 : last - first;
        }

        private boolean isPrime(int num) {
            if(num == 1) return false;
            for (int i = 2; i < num; i++) {
                if(num % i == 0) return false;
            }
            return true;
        }
    }
}
