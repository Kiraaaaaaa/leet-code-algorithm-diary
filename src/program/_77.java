package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }
    public static class Solution{
        //temp数组存放临时已经被选出的数字，代表为一种组合
        List<Integer> temp = new ArrayList<>();
        //答案集合
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
        }
        // 回溯，参数:当前值，最大值，组合长度
        private void dfs(int cur, int max, int len) {
            //剪枝，如果临时数组的长度加上最大值max减去当前值cur+1小于组合长度，说明不可能满足指定的组合长度，没必要递归了，如max=10, len=9的情况
            if(temp.size() + max - cur + 1 < len){
                return;
            }
            //临时数组的长度等于指定组合长度，说明已经找到一种组合，将其添加到答案集合中
            if(temp.size() == len){
                //深拷贝方式将temp数组添加到答案集合中，避免在递归过程中影响到原来已经确定的数组
                ans.add(new ArrayList<>(temp));
                return;
            }
            /**
             * 这里代表两种策略：取当前值，还是不取当前值
             */
            //如果取当前值，则把当前值放到临时数组中，并且开始求解子问题，期间会得到如-->1,2,3-->1,3,4...
            temp.add(cur);
            dfs(cur+1, max, len);
            //如果不取当前值，则把当前值值从临时数组中删除，之后开始回溯
            temp.remove(temp.size()-1);
            //子问题开始回溯，另外当从子问题回溯到最上层的时候，此时当前值变成2，将开始进行第二轮如-->2,3,4-->2,4,5..
            dfs(cur+1, max, len);
        }
    }
}
