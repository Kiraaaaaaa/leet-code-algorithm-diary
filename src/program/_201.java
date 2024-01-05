package program;

import java.util.ArrayList;
import java.util.List;

public class _201 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.rangeBitwiseAnd(5, 7);
        System.out.println(res);
    }
    public static class Solution{
        public int rangeBitwiseAnd(int left, int right) {
            int len = 0;
            //利用循环求出公共部分，并记录下非公共部分的长度
            while(left!=right){
                left >>= 1;
                right >>= 1;
                ++len;
            }
            return left<<=len;
        }
    }
}
