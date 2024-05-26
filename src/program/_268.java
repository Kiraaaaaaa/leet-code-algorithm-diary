package program;

import java.util.Arrays;

public class _268 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.missingNumber_1(new int[]{0,1});
        System.out.println(res);
    }
    public static class Solution {

        //方法1.使用一个记录表存储数字出现的次数，出现次数为0的就是丢失的数字
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int[] count = new int[n+1];
            int res = 0;
            for (int i = 0; i < n; i++) {
                 count[nums[i]]++; // 记录数字出现次数
            }
            for (int i = 0; i <= n; i++) {
                if(count[i] == 0) res = i;
            }
            return res;
        }

        //方法2.只需要一次遍历，时间复杂度O(n), 用1到n相加的数减去数组中存在的数，得到丢失的数
        public int missingNumber_1(int[] nums) {
            int total = 0, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                total += i + 1;
                sum += nums[i];
            }
            return total - sum;
        }

        //方法3.排序，只要坐标和值不相等，就返回坐标
        public int missingNumber_2(int[] nums) {
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if(i != nums[i]-1) return i;
            }
            return nums.length;
        }
    }
}
