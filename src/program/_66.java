package program;

import java.util.Arrays;

public class _66 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.plusOne(new int[]{9, 2, 9});
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static class Solution {
        public int[] plusOne(int[] digits) {
            for (int i =  digits.length-1; i >= 0; i--) {
                //先自增
                digits[i]++;
                //如果该位为9，则重置为0
                digits[i] = digits[i] % 10;
                //如果该位不为9，那么说明不是99这种特殊情况，直接返回自增后的结果
                if(digits[i] != 0) return digits;
            }
            //如果所有位都为9，则新增一个长度为原数组长度+1的数组，并将第一个一个元素置为1，然后返回该数组
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }
    }
}
