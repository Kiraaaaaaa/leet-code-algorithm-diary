package program;

import java.util.ArrayList;
import java.util.List;

public class _39 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static class Solution {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, target, 0);
            return ans;
        }
        public void dfs(int[] candidates, int target, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 递归下去，并且起到跳过(数组越界、target小于当前数)的作用
            dfs(candidates, target, idx + 1);
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], idx);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
