package program;

public class _190 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            //最终结果默认为0
            int res = 0;
            //由于给定的二进制位数固定为32，所以针对这32位进行位运算
            for (int i = 31; i >= 0; i--) {
                //解释：
                //将n的最低位(最右边的一位)，和1做与运算，得到最低位的二进制值，然后将此二进制值左移i个位置。此时左移完后的值与res做或运算，将此二进制值"添加"到res中
                res |= (n&1) << i;
                //每次将n的最低位移到res的前面后，n右移一位，直至n为0，此时res已经将n的二进制值全部添加到res中，返回res即可
                n >>>= 1;
            }
            return res;
        }
    }
}
