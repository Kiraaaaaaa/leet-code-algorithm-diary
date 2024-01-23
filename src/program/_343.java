package program;

public class _343 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.integerBreak(10);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.尽量多的拆分出3，其次是2。
        public int integerBreak(int n) {
            if(n <= 3) return n-1;
            int a = n/3, b = n%3;
            if(b == 0) return (int) Math.pow(3,a);
            if(b == 1) return (int) Math.pow(3, a-1) * 4;
            return (int) Math.pow(3, a) * 2;
        }
    }
}
