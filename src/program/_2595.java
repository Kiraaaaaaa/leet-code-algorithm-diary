package program;

public class _2595 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.evenOddBit(17);
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static class Solution {
        public int[] evenOddBit(int n) {
            int[] res = new int[2];
            String num = Integer.toBinaryString(n);
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if(c == '1') ++res[(num.length()-i-1)%2]; //注意题目中的坐标是从右往左开始算的，所以需要简单计算一下坐标的奇偶
            }
            return res;
        }
    }
}
