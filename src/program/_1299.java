package program;

import java.io.ObjectInput;
import java.util.ArrayList;

public class _1299 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.replaceElements(new int[]{100});
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static class Solution {
        //方法1.维护最大后缀。从后往前遍历，维护一个最大值
        public int[] replaceElements(int[] arr) {
            int preMax = -1; //该元素后面的最大值(比较的范围不包括该元素)
            for(int i = arr.length-1; i>=0; i--){
                int max = Math.max(preMax, arr[i]); //更新该元素为之后的最大值
                arr[i] = preMax; //设置该元素为之前的最大值
                preMax = max; //比较的范围包括该元素的最大值，为下一次比较做准备
            }
            return arr;
        }
    }
}
