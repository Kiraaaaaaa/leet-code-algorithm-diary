package program;

import java.util.ArrayList;
import java.util.Collections;

public class _645 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.findErrorNums(new int[]{1,1});
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static class Solution {
        //方法1.先记录每个数的出现次数，然后从1枚举每一个数，只要没出现过就是正确的数
        public int[] findErrorNums(int[] nums) {
            int[] count = new int[10001];
            int[] res = new int[2];
            int errorNum = -1;
            for (int num : nums) {
                count[num]++; //记录出现次数
                if(count[num] == 2) errorNum = num; //记录下错误数
            }
            res[0] = errorNum;
            //由于数组要求出现的值是从1到n，所以从1开始找正确的值
            for(int i=1; i <= nums.length; i++){
                if(count[i] == 0){ //如果找到一个没有出现的值，那么就是正确的值
                    res[1] = i;
                    break;
                }
            }
            return res;
        }
    }
}
