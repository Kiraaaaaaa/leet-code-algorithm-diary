package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _75 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,0,2,1,1,0};
        solution.sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static class Solution{
        //方法1：两两比较，冒泡排序法
        public void sortColors(int[] nums) {
            for (int i = 0; i < nums.length; i++) {

            }
        }
    }
}
