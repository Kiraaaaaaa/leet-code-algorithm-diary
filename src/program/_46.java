package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
    public static class Solution{
        //答案集合
        List<List<Integer>> ans = new ArrayList<>();
        //当前的排列组合
        ArrayList<Integer> temp = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            for (int num : nums) {
                temp.add(num);
            }
            dfs(nums, 0);
            return ans;
        }

        private void dfs(int[] nums, int index) {
            // if(nums.length == temp.size()) ans.add(new ArrayList<>(temp));
            if(nums.length == index) ans.add(new ArrayList<>(temp));
            for (int i = index; i < nums.length; i++) {
                Collections.swap(temp, index, i);
                dfs(nums, index+1);
                Collections.swap(temp, index, i);
            }
        }
    }
}
