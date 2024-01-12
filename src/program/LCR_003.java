package program;

import java.util.Arrays;

public class LCR_003 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.countBits_1(5);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static class Solution {
        //方法1.不讲武德API
                public int[] countBits(int n) {
                    int[] arr = new int[n+1];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = Integer.bitCount(i);
                    }
                    return arr;
                }
        //方法2.位运算
        public int[] countBits_1(int n) {
            int[] arr = new int[n + 1];
            for (int i = 0; i < arr.length; i++) {
                int num = i;
                int count = 0;
                while(num != 0){
                    count += num & 1;
                    //num右移一位
                    num = num >> 1;
                }
                arr[i] = count;
            }
            return arr;
        }
    }
}
