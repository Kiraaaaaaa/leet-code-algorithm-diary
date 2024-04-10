package program;

public class _713 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.numSubarrayProductLessThanK_1(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19);
        System.out.println(res);
    }
    static class Solution {
        //方法1.暴力，枚举出每一种区间
        //已优化部分：如果枚举的左起点数大于等于k，则直接跳过。如果在构建区间的过程中乘积大于等于k了跳出循环，开始枚举下一个左起点。
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] >= k) continue; // 大于等于k的数直接跳过
                res++; // 只有一位也可以代表一个区间
                int prod = nums[i]; // prod记录区间乘积
                for (int j = i + 1; j < nums.length; j++) {
                    prod *= nums[j]; // 更新区间乘积
                    if(prod<k) res++; // 只要区间乘积还小于k，则区间加1
                    else break; // 大于等于k了，跳出循环，枚举下一个起点
                }
            }
            return res;
        }
        //方法2.滑动窗口
        public int numSubarrayProductLessThanK_1(int[] nums, int k) {
            if(k <= 1) return 0; //特殊情况
            int res = 0, prod = 1, left = 0; // prod记录区间乘积，left代表左指针
            for (int right = 0; right < nums.length; right++) { // right模拟右指针移动
                prod *= nums[right]; //得到区间乘积
                while(prod >= k) { //只要区间乘积大于等于k，左指针开始右移
                    prod /= nums[left++]; //左指针右移一位，同时区间乘积要除去被移出去的数
                }
                res += right - left + 1; //只要知道区间左右两坐标就可以算出组成的区间可能性有多少种，这是一种【求出包含自身的全排列数量】方式
            }
            return res;
        }
    }
}
