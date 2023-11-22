package 刷题;
import java.util.Arrays;

public class _128 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,2,7,8,8,9};
        int i = solution.longestConsecutive(nums);
        System.out.println(i);
    }

    /**
     * 思路
     * 由于不考虑元素在数组中的顺序问题，所以直接排序输出最长的序列即可
     * 如何找出最长区间？
     * 可以将排序好的数组中取当前点作为一个起点，比较自己和上一位置的大小
     * 查看当前数字在哪种状态：
     * 1.如果自己比上一位刚好大一个数字，则更新当前连续区间的长度+1，并比较目前最大连续区间的长度，大于后者便更新最大区间
     * 2.如果自己和上一位是同一个数字则只需要更新最大区间即可，因为如[0,0,0]全部一样的例外，所以必须更新
     * 3.如果自己和上一位以上情况都不是，如[1,7]，则需要重置当前连续区间的长度为1
     */

    public static class Solution {
        public int longestConsecutive(int[] nums) {
            
            //排除数组长度为0和1的特殊情况
            //最后一个例子就是[]，导致没一遍过，太坑了
            if(nums.length==0) return 0;
            if(nums.length==1) return 1;

            //最大连续区间大小
            int maxLength = 1;
            //当前连续区间大小
            int nowLength = 1;
            Arrays.sort(nums);
            // 在简单排序下，用stream流排序貌似要慢点
            // int[] sortNums = Arrays.stream(nums).sorted().toArray();

            //从第二位开始
            for (int i = 1; i < nums.length; i++) {
                //如果自己比上一位刚好大一个数字，则更新目前区间大小
                if(nums[i] == nums[i-1]+1){
                    nowLength++;
                }else if(nums[i] > nums[i-1]){
                    //如果自己比上一位大，说明来到新区间了，重置区间长度
                    nowLength = 1;
                }
                //剩下情况就是两个数相同了，不需要更新目前区间
                //但每次都需要更新最大区间
                if(maxLength < nowLength){
                    maxLength = nowLength;
                }
            }
            return maxLength;
        }
    }
}
