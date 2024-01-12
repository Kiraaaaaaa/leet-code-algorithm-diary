package program;

import java.util.Arrays;

public class _976 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.largestPerimeter_1(new int[]{2, 1, 2});
        System.out.println(res);
    }
    public static class Solution{
        //方法1.暴力枚举，超时
        public int largestPerimeter(int[] nums) {
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    for(int k = j + 1; k < nums.length; k++){
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[k];
                        //由于无序，所以无法使用下个方法的判断方法
                        //三角形性质之一：任意两个边长和大于另外一条边长
                        if(a + b > c && a + c > b && b + c > a){
                            max = Math.max(max, a + b + c);
                        }
                    }
                }
            }
            return max;
        }
        //方法2.先从大到小排序，利用三角形性质求最大边长
        public int largestPerimeter_1(int[] nums) {
            Arrays.sort(nums);
            for (int i = nums.length-1; i >= 0; i--) {
                int a = nums[i];
                int b = nums[i-1];
                int c = nums[i-2];
                //排序后才可以使用此性质
                //三角形性质之一：最大边长小于其它两条边长和
                if(a < b + c){
                    return a+b+c;
                }
            }
            return 0;
        }
    }
}
