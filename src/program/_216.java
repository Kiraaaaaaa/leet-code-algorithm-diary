package program;

import java.util.ArrayList;
import java.util.List;

public class _216 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum3(3, 7);
        System.out.println(res);
    }

    //方法1.从前往后
    public static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int len;
        public List<List<Integer>> combinationSum3(int k, int n) {
            len = k;
            dfs(0, 0, n);
            return res;
        }

        private void dfs(int index, int k, int n) {
            if(n == 0 && k == len){ //只有这几个数可以组合成n，并且这几个数的长度刚好等于k
                res.add(new ArrayList<>(temp)); //添加到结果集
                return;
            }
            for (int i = index+1; i <= 9; i++) { //从1到9尝试每个数字都作为第一个数字开始递归
                temp.add(i); //选取当前数字
                dfs(i, k+1, n-i); //选取后，当前已添加数字个数+1，待组合数字-i
                temp.remove(temp.size()-1); //不选取当前数字，当前位尝试选取下一个数字
            }
        }
    }
    //方法2.从后往前
    public static class Solution_1{
        int len;
        private final List<Integer> temp = new ArrayList<>(); //存放正在尝试的组合
        private final List<List<Integer>> ans = new ArrayList<>(); //存放最终结果
        public List<List<Integer>> combinationSum3_1(int k, int n) {
            len = k;
            dfs_1(9, n); //从后往前模拟1~9的数字
            return ans;
        }

        private void dfs_1(int num, int sum) {
            int size = len - temp.size(); //剩余待模拟的数字数量
            if(sum < 0 || sum > (num * 2 - size + 1) * size / 2){ //剪枝
                return;
            }
            if(size == 0){
                ans.add(new ArrayList<>(temp));
                return;
            }
            //两种策略，1.不选取自身（需要剩余的数字大于剩余待模拟的数字数量，否则是必选）
            if(num > size) dfs_1(num - 1, sum); //不减少总和
            //2.选取自身
            temp.add(num); //添加自身的数字到正在尝试的组合中
            dfs_1(num - 1, sum - num); //总和-当前数字
            temp.remove(temp.size() - 1); //从正在尝试的组合中删除最后一个尝试的数字，代表回到上一步
        }
    }
}
