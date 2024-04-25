package program;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
    }
    //方法1.递归到最右边的数字，然后从右往左遍历尝试添加数字(官解)
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

    //方法2.这个更好理解，从左往右，优先添加自己，再添加右边的数
    public static class Solution_1 {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates); //先排序，当尝试添加第n个数字后大于target，则不用向后尝试了
            dfs_1(candidates, target, 0);
            return ans;
        }

        private void dfs_1(int[] candidates, int target, int index) {
            if(index == candidates.length) return;
            if(target == 0) ans.add(new ArrayList<>(combine)); //如果目标数减为了0，则找到一个组合，添加到结果中
            for (int i = index; i < candidates.length; i++) {
                if(candidates[i] > target) break; //剪枝，如果当前要添加的数大于了目标数，则不用向后尝试了，因为排序后后面的数都比当前数大
                combine.add(candidates[i]); //添加当前数
                dfs_1(candidates, target - candidates[i], i); //优先尝试添加自身，所以index不变
                combine.remove(combine.size() - 1); //移除当前数，去尝试添加后面几位
            }
        }
    }
}
