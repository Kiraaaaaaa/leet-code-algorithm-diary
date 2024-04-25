package program;

import java.util.ArrayList;
import java.util.List;

public class __216 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum3(3, 9);
        System.out.println(res);
    }
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
}
