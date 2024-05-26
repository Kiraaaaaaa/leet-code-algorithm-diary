package program;

import java.util.Arrays;
import java.util.Comparator;

public class _2644 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxDivScore(new int[]{73,13,20,6}, new int[]{56,24,56});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.暴力，如果被除个数>之前的记录，结果就是当前divisor，如果和之前的记录一样，和之前的答案比较取最小的divisor
        public int maxDivScore(int[] nums, int[] divisors) {
            int res = 0, max = 0; //res为答案，max为当前最大被除个数
            for (int i = 0; i < divisors.length; i++) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j] % divisors[i] == 0) count++; //记录当前divisor能被多少个数整除
                }
                if(count > max){ //如果当前divisor能被更多的数整除
                    max = count; //更新最大被除个数
                    res = divisors[i]; //更新res为当前divisor
                }
                else if(count == max){ //如果当前divisor被整除的个数和之前的divisor一样
                    res = Math.min(res, divisors[i]); //更新res为最小的divisor
                }
            }
            return res;
        }
    }
}
