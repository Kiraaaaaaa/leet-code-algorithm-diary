package program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _50 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double res = solution.myPow_1(2, 10);
        System.out.println(res);
    }
    public static class Solution {
        private int res;
        // 方法1：暴力递归，但无法过x=0.00001 n=2147483647
        public double myPow(double x, int n) {
            if(n == 1 || n == -1) return n<0?1/x:x;
            return n<0 ? myPow(x, n+1)/x : x*myPow(x, n-1);
        }

        // 方法2：快速幂递归
        public double myPow_1(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }
        public double quickMul(double x, long N) {
            //N==0，代表任何数的0次方都是1
            if (N == 0) {
                return 1.0;
            }
            //前往下一层递归，得到y在本层计算结果
            double y = quickMul(x, N / 2);
            //根据N的奇偶性，便知需不要乘上X，举例:数的4次方等于数的2次方的平方，而5次方等于(数的2次方的平方)*X
            return N % 2 == 0 ? y * y : y * y * x;
        }
    }
}
