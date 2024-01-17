package program;

public class _1009 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.bitwiseComplement(5);
        System.out.println(res);
    }
    public static class Solution {
        public int bitwiseComplement(int n) {
            if(n == 0) return 1;
            int offset = 0; //n的个位经过取反运算后需要偏移的位数
            int res = 0; //最终结果
            while(n != 0){
                //解释：n的个位进行异或运算，得到该位取反结果然后左移offset位，然后将结果与res进行或运算，将n的该位取反的数字添加到res中
                res = res | ((n & 1 ^ 1)<<offset++);
                n>>>=1; //该位完成计算后，n右移一位
            }
            return res;
        }
    }
}
