package program;

public class _100300 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.sumDigitDifferences_1(new int[]{13, 23, 12});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.暴力（超时）
        public long sumDigitDifferences(int[] nums) {
            long res = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int a = nums[i];
                    int b = nums[j];
                    while(a > 0){
                        res += (a%10 == b%10) ? 0 : 1;
                        a/=10;
                        b/=10;
                    }
                }
            }
            return res;
        }

        //方法2.拆位算贡献
        public long sumDigitDifferences_1(int[] nums) {
            return 1L;
        }
    }
}
