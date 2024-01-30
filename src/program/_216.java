package program;

import java.util.ArrayList;
import java.util.List;

public class _216 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum3(3, 7);
        System.out.println(res);
    }
    public static class Solution{
        int len;
        private final List<Integer> temp = new ArrayList<>(); //存放正在尝试的组合
        private final List<List<Integer>> ans = new ArrayList<>(); //存放最终结果
        public List<List<Integer>> combinationSum3(int k, int n) {
            len = k;
            dfs(9, n); //从后往前模拟1~9的数字
            return ans;
        }

        private void dfs(int num, int sum) {
            int size = len - temp.size(); //剩余待模拟的数字数量
            if(sum < 0 || sum > (num * 2 - size + 1) * size / 2){ //剪枝
                return;
            }
            if(size == 0){
                ans.add(new ArrayList<>(temp));
                return;
            }
            //两种策略，1.不选取自身（需要剩余的数字大于剩余待模拟的数字数量，否则是必选）
            if(num > size) dfs(num - 1, sum); //不减少总和
            //2.选取自身
            temp.add(num); //添加自身的数字到正在尝试的组合中
            dfs(num - 1, sum - num); //总和-当前数字
            temp.remove(temp.size() - 1); //从正在尝试的组合中删除最后一个尝试的数字，代表回到上一步
        }
    }
}
