package program;

import java.util.HashSet;

public class _2670 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.distinctDifferenceArray(new int[]{37,37,37,37,33});
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int[] preSum = new int[nums.length]; //记录前面不同的数字数量
            int[] tailSum = new int[nums.length]; //记录后面不同的数字数量
            HashSet<Integer> preSet = new HashSet<>(); //记录前面中出现的不同数字
            HashSet<Integer> tailSet = new HashSet<>(); //记录前面中出现的不同数字
            for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
                if(!preSet.contains(nums[i])){ //记录前面的不同数字个数
                    preSum[i] = preSet.size()+1;
                    preSet.add(nums[i]);
                }else{
                    preSum[i] = preSet.size();
                }
                if(!tailSet.contains(nums[j])){  //记录后面的不同数字个数
                    tailSum[j] = tailSet.size();
                    tailSet.add(nums[j]);
                }else{
                    tailSum[j] = tailSet.size();
                }
                if(i >= j){ //如果两指针相遇，则可以开始计算差值了
                    nums[i] = preSum[i] - tailSum[i];
                    nums[j] = preSum[j] - tailSum[j];
                }
            }
            return nums;
        }
    }
}
