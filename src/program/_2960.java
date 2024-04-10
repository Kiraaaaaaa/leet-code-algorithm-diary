package program;

public class _2960 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.countTestedDevices(new int[]{1, 1, 2, 1, 3});
        System.out.println(res);
    }
    static class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int res = 0;
            for (int num : batteryPercentages) {
                if(num - res > 0) res++;
            }
            return res;
        }
    }
}
