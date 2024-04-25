package program;

public class _1052 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxSatisfied(new int[]{4,10,10}, new int[]{1,1,0}, 2);
        System.out.println(res);
    }
    public static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int res = 0;
            int n = customers.length;
            int[] arr = new int[n]; // 前缀和
            arr[0] = grumpy[0] == 0 ? customers[0] : 0;
            for (int i = 1; i < customers.length; i++) {
                arr[i] = grumpy[i] == 0 ? arr[i-1]+customers[i] : arr[i-1];
            }
            for (int i = 0; i <= n-minutes; i++) {
                int sum = 0; // 当前窗口内生气的顾客和
                for (int j = i; j < i+minutes; j++) {
                    if(grumpy[j] == 1) sum += customers[j];
                }
                res = Math.max(sum + arr[n-1], res); // 当前窗口内生气的顾客和 + 所有不生气的顾客和
            }
            return res;
        }
    }
}
