package program;

public class _2529 {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.maximumCount_1(new int[]{-3,-2,-1,0,0,1,2});
        System.out.println(res);
    }
    static class Solution {
        //方法1.二分查找。写得有点乱，思路有点麻烦，只是为了说明二分是可行的
        public int maximumCount(int[] nums) {
            int l = 0, n = nums.length, r = n - 1;
            while(l <= r){
                int mid = (r + l) >>> 1;
                if(nums[mid] >= 0) r = mid - 1; //如果区间中点仍然为正数或者0，那么右指针变成中点，准备取左区间中点
                else l = mid + 1; //如果区间中点为负数，那么左指针变换为中点，准备取右区间中点
            }
            int num1 = l;
            r = n - 1;
            while(l <= r){
                int mid = (r + l) >>> 1;
                if(nums[mid] == 0) l = mid + 1; //如果区间中点仍然为负数，那么左指针向右移动一位
                else r = mid - 1; //如果区间中点为正数，那么右指针变换为中点，准备取左区间中点
            }
            int num2 = n - l;
            return num1 > num2 ? num1 : num2;
        }
        //方法2.线性遍历
        public int maximumCount_1(int[] nums) {
            int num1 = 0, num2 = 0;
            for (int num : nums) {
                num1 += num < 0 ? 1 : 0;
                num2 += num > 0 ? 1 : 0;
            }
            return Math.max(num1, num2);
        }
    }
}
