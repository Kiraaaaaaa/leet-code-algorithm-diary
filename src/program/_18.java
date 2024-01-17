package program;

import java.util.*;

public class _18 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.fourSum(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 8);
        System.out.println(list);
    }
    public static class Solution {
        //方法1.暴力超时
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i <= nums.length - 4; i++) {
                for(int j = i+1; j <= nums.length - 3; j++){
                    for(int k = j+1; k <= nums.length - 2; k++){
                        for(int l = k+1; l <= nums.length - 1; l++){
                            if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                                List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l]));
                                Collections.sort(list);
                                if(!lists.contains(list)){
                                    lists.add(list);
                                }
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(lists);
        }
    }
}
