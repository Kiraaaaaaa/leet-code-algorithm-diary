package program;

import java.util.Arrays;
import java.util.Random;

public class _162 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findPeakElement(new int[]{1});
        System.out.println(res);
    }
    public static class Solution {

        //方法1.不那么正经的随机数访问，然后判断前一个元素和后一个元素是否都小于自身
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            if(n == 1) return 0; //只有一个元素，那么峰值就是他自身
            Random random = new Random();
            while(true){
                int index = random.nextInt(nums.length); //使用随机数获得一个坐标
                //如果当前元素在数组中间，那么判断其左右两个元素是否小于当前元素，如果是，那么当前元素就是峰值
                if(index > 0 && index < nums.length - 1 && nums[index-1] < nums[index] && nums[index] > nums[index+1]) return index;
                if(index == 0 && nums[1] < nums[0]) return 0; //如果是第一个元素并且第二个元素比第一个元素小，那么第一个元素就是峰值
                if(index == n - 1 && nums[n - 1] > nums[n - 2]) return n - 1; //如果是最后一个元素并且最后一个元素比倒数第二个元素大，那么最后一个元素就是峰值
            }
        }
    }
}
