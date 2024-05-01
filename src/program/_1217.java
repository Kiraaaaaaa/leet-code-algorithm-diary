package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _1217 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minCostToMoveChips(new int[]{2,2,2,3,3});
        System.out.println(res);
    }


    public static class Solution {
        //方法1.只需要统计偶数位和奇数位有多少数字，然后返回较小的即可
        public int minCostToMoveChips(int[] ratings) {
            int two = 0, one = 0;
            for (int i = 0; i < ratings.length; i++) {
                if(ratings[i] % 2 == 0){
                    two++;
                }else{
                    one++;
                }
            }
            return two > one ? one : two;
        }
    }
}
