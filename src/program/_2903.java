package program;

import java.util.HashSet;

public class _2903 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.findIndices_1(new int[]{5, 1, 4, 1}, 2, 4);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static class Solution {
        //方法1.双重循环暴力
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            int n = nums.length;
            int[] res = new int[]{-1, -1};
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if(Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference){
                        res[0] = i;
                        res[1] = j;
                        break;
                    }
                }
            }
            return res;
        }

        //方法2.记录最大值和最小值，遍历过程中和这两比较得到合适的结果
        public int[] findIndices_1(int[] nums, int indexDifference, int valueDifference) {
            int n = nums.length;
            int min = 0, max = 0;
            for (int j = indexDifference; j < n; j++) {
                int i = j - indexDifference;
                if(nums[i] > nums[max]){
                    max = i;
                }else if(nums[i] < nums[min]){
                    min = i;
                }
                // 因为找出其中一个符合条件的答案即可，所以只需要判断最大、最小值和当前值的差即可，他们能得到一个最大差值
                if(nums[j] - nums[min] >= valueDifference) return new int[]{min, j};
                if(nums[max] - nums[j] >= valueDifference) return new int[]{max, j};
            }
            return new int[]{-1, -1};
        }
    }
}
