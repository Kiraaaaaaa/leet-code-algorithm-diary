package program;

import java.util.ArrayList;
import java.util.List;

public class _78 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }
    public static class Solution{
        //temp数组存放临时已经被选出的数字，代表为一种组合
        List<Integer> temp = new ArrayList<>();
        //答案集合
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }
        private void dfs(int cur, int[] nums) {
            if(cur == nums.length){
                ans.add(new ArrayList<>(temp));
                return;
            }
            /**
             * 这里代表两种策略：取当前值，还是不取当前值
             */
            //如果取当前值，则把当前值放到临时数组中，并且开始求解子问题
            temp.add(nums[cur]);
            dfs(cur+1, nums);
            //如果不取当前值，则把当前值值从临时数组中删除，之后开始回溯
            temp.remove(temp.size()-1);
            //子问题开始回溯，另外当从子问题回溯到最上层的时候，此时当前值变成[]
            dfs(cur+1, nums);
        }
    }
}
