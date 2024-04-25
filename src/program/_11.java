package program;

import java.util.ArrayList;
import java.util.List;

public class _11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int res = solution.maxArea(nums);
        System.out.println(res);
    }
    public static class Solution{
        /**
         * 使用双指针，每次比较两指针的值，数值较低的一方向内移动，因为数值较低的才能决定水桶容量，继续拓展看是否能得到更高的高度
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int max = 0, left = 0, right = height.length - 1;
            while(left < right){
                //最大区间值 = 区间内最低值 * 区间长度
                max = Math.max(max, Math.min(height[left], height[right])*Math.abs(right-left));
                //左边值更低，更新左指针
                if(height[left] < height[right]){
                    left++;
                }else{
                    //右边值更低，更新右指针
                    right--;
                }
            }
            return max;
        }
    }
}
