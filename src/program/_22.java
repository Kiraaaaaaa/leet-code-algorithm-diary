package program;

import java.util.ArrayList;
import java.util.List;

public class _22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
    public static class Solution {
        int size;
        char[] s;
        List<String> res;
        public List<String> generateParenthesis(int n) {
            size = n;
            res = new ArrayList<>();
            s = new char[2 * n];
            dfs(0, 0); // index: 已选位置，left: 左括号已选数量
            return res;
        }

        private void dfs(int index, int left) {
            if(index == 2*size){
                res.add(new String(s)); // 已选完
                return;
            }
            if(left < size){ // 只要左括号能选，则选左括号
                s[index] = '('; // 记录该位置选取了一个左括号
                dfs(index+1, left+1); // 选下一个位置
            }
            if(index - left < left){ // 右括号数量不能大于等于左括号数量，此时才能选右括号
                s[index] = ')';
                dfs(index+1, left); // 选下一个位置。因为选的是右括号，所以left不变
            }
        }
    }
}
