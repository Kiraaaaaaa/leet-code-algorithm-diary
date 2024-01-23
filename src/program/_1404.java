package program;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class _1404 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSteps_1("1111011110000011100000110001011011110010111001010111110001");
        System.out.println(res);
    }
    public static class Solution {
        //如果精度在int以内可以这样写
        public int numSteps(String s) {
            int num = Integer.parseInt(s, 2);
            int res = 0;
            while(num != 1){
                if((num&1)==1) num += 1; //加1
                else num >>= 1; //除2
                ++res;
            }
            return res;
        }
        //如果精度大于long可以这样写
        public int numSteps_1(String s) {
            BigInteger num = new BigInteger(s, 2);
            int res = 0;
            while(num.compareTo(BigInteger.ONE) != 0){
                if((num.and(BigInteger.ONE)).equals(BigInteger.ONE)) num = num.add(BigInteger.ONE); //加1
                else num = num.shiftRight(1); //除2
                ++res;
            }
            return res;
        }
    }
}
