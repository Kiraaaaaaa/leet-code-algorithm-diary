package program;

public class _2574 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.leftRightDifference(new int[]{1});
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static class Solution {
        //解法1.双指针+前后缀和
        public int[] leftRightDifference(int[] nums) {
            int[] a = new int[nums.length]; //前缀和数组
            int[] b = new int[nums.length]; //后缀和数组
            int left = 0, right = nums.length - 1; //左右指针反方向从数组头尾出发
            int leftSum = 0, rightSum = 0; //前缀和后缀累加数字
            while(left < nums.length){ //遍历完一遍数组结束
                a[left] = leftSum; //存储该位的前缀和
                b[right] = rightSum; //存储该位的后缀和
                leftSum += nums[left]; //更新前缀和
                rightSum += nums[right]; //更新后缀和
                if(left >= right){ //如果左右指针重合了，开始前后缀和相减
                    nums[left] = Math.abs(a[left] - b[left]); //更新该位前后缀和的差值，修改坐标举例: 2, 3
                    nums[right] = Math.abs(a[right] - b[right]); //更新该位前后缀和的差值，修改坐标举例: 1, 0
                }
                ++left; --right; //移动指针
            }
            return nums;
        }
    }
}
