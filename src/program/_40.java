package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 27));
    }
    public static class Solution{
        //temp数组存放临时已经被选出的数字，代表为一种组合
        List<Integer> temp = new ArrayList<>();
        //答案集合
        List<List<Integer>> ans = new ArrayList<>();
        //temp数组已经选出的数字总数
        int count = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);  // 对候选数字数组进行排序
            dfs(0,candidates, target);
            return ans;
        }
        //参数：1.当前数组坐标2.数组3.目标值
        private void dfs(int cur, int[] nums, int target) {
            //如果已经遍历完所有数字了，并且其组合的值刚好等于目标值，则将其加入到答案集合中
            if(cur == nums.length){
                //需要注意的时候不能添加元素重复的组合
                ArrayList<Integer> sort = new ArrayList<>(temp);
                Collections.sort(sort);
                //为了不改变原数组，需要将temp数组复制一份，排序，判断ans不存在该组合才放进去
                if(count == target && !ans.contains(sort)){
                    ans.add(new ArrayList<>(sort));
                }
                return;
            }
            /**
             * 这里代表两种策略：取当前值，还是不取当前值
             */
            //如果取当前值，则把当前值放到临时数组中，并且开始求解子问题
            temp.add(nums[cur]);
            count+=nums[cur];
            dfs(cur+1, nums, target);
            //如果不取当前值，则把当前值值从临时数组中删除，之后开始回溯
            temp.remove(temp.size()-1);
            count-=nums[cur];
            //子问题开始回溯，另外当从子问题回溯到最上层的时候，此时当前值变成[]
            dfs(cur+1, nums, target);
        }
    }
}
