package program;

import java.util.ArrayList;
import java.util.List;

public class _1550 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.threeConsecutiveOdds(new int[]{1, 2, 1, 1});
        System.out.println(res);
    }
    public static class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int count = 0;
            for (int i = 0; i < arr.length && count < 3; i++, ++count) {
                if((arr[i] & 1) != 1) count = -1; //如果该数为偶数则重新开始计数
            }
            return count == 3;
        }
    }
}
