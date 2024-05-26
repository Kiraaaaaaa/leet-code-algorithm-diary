package program;

public class _100274 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumEnergy_1(new int[]{-2,-3,-1}, 2);
        System.out.println(res);
    }
    public static class Solution {

        //方法1(超时).暴力
        public int maximumEnergy(int[] energy, int k) {
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < energy.length; i++) {
                int sum = 0;
                for (int j = i; j < energy.length; j+=k) {
                    sum += energy[j];
                }
                res = Math.max(res, sum);
            }
            return res;
        }

        //方法2.递推，从后往前积累各自的和
        public int maximumEnergy_1(int[] energy, int k) {
            int n = energy.length;
            int res = Integer.MIN_VALUE;
            int[] f = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                f[i] = energy[i];
                if(i+k < n) f[i] += f[i+k];
            }
            for (int i = 0; i < n; i++) {
                res = Math.max(f[i], res);
            }
            return res;
        }
    }
}
