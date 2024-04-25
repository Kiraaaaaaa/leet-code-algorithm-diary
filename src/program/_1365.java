package program;

import java.util.Arrays;

public class _1365 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int[] res = so.smallerNumbersThanCurrent_1(new int[]{8, 1, 2, 2, 3});
        for (int re : res) {
            System.out.println(re);
        }
    }
    static class Solution {
        //方法1.暴力
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if(nums[i] > nums[j]) res[i]++;
                }
            }
            return res;
        }
        //方法2.排序
        public int[] smallerNumbersThanCurrent_1(int[] nums) {
            int n = nums.length;
            int[][] data = new int[n][2]; //存数组元素和对应下标
            int[] res = new int[n];
            for (int i = 0; i < nums.length; i++) {
                data[i][0] = nums[i]; //存该数字
                data[i][1] = i; //存该数字下标
            }
            Arrays.sort(data, (a, b) -> a[0] - b[0]); //从小到大排序
            int pre = 0; //如果有该数在数组中有多个，那么此变量将用于记录该数大于了多少数
            for (int i = 0; i < n; i++) {
                if(i > 0 && data[i-1][0] != data[i][0]){ //如果当前数与前一个数不同，那么当前数大于了pre个数，反之pre不变
                    pre = i;
                }
                res[data[i][1]] = pre;
            }
            return res;
        }
    }
}
