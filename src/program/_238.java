package program;

import java.util.ArrayList;
import java.util.Arrays;

public class _238 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rs = solution.productExceptSelf(new int[]{1,2,3,4});
        Arrays.stream(rs).forEach(System.out::println);
    }
    public static class Solution{
        //解法1.前后缀积相乘
        public int[] productExceptSelf(int[] nums) {
            //cache[nums.length][2]中两个坐标分别表示当前元素正序、倒序的乘积
            int[][] cache = new int[nums.length][2];
            //除开当前元素的所有乘积(答案)
            int[] res = new int[nums.length];
            int len = nums.length - 1;
            //左指针i移动过程中(正序)记录下每个元素自身与其左边元素的乘积
            //右指针j反之
            for (int i = 0, j = len; i <= len; i++, j--) {
                //1.计算正序的乘积集合
                //如果左指针在最左边，则直接将当前元素作为乘积放入
                if(i == 0){
                    cache[i][0] = nums[i];
                }else{ //否则，乘积等于上一个元素的乘积*当前元素，计算后放入
                    cache[i][0] = cache[i-1][0] * nums[i];
                }
                //2.计算倒序的乘积集合
                //如果右指针在最右边，则直接将当前元素作为乘积放入
                if(j == len){
                    cache[j][1] = nums[j];
                }else{ //否则，乘积等于后一个元素的乘积*当前元素，计算后放入
                    cache[j][1] = cache[j+1][1] * nums[j];
                }
            }
            //3.开始计算每一位除自身的乘积
            for (int i = 0; i <= len; i++) {
                if(i==0){ //第一位元素取其右边一位倒序的乘积
                    res[i] = cache[i+1][1];
                }else if(i==len){ //最后一位元素取其左边一位正序的乘积
                    res[i] = cache[i-1][0];
                }else{ //中间元素取其左边一位正序乘积*其右边一位倒序乘积
                    res[i] = cache[i-1][0] * cache[i+1][1];
                }
            }
            return res;
        }
        //解法2.前后缀积相乘，优化空间复杂度到o(1) todo

    }
}
