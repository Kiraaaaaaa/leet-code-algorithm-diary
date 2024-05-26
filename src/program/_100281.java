package program;

import java.util.ArrayList;
import java.util.List;

public class _100281 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of(9,5,7,3)));
        list.add(new ArrayList<>(List.of(8,9,6,1)));
        list.add(new ArrayList<>(List.of(6,7,14,3)));
        list.add(new ArrayList<>(List.of(2,5,3,1)));
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(new ArrayList<>(List.of(4,3,2)));
        list1.add(new ArrayList<>(List.of(3,2,1)));
        int res = solution.maxScore(list);
        System.out.println(res);
    }
    public static class Solution {
        int m, n;
        int res = Integer.MIN_VALUE;
        public int maxScore(List<List<Integer>> grid) {
            m = grid.size();
            n = grid.get(0).size();
            for (int i = 1; i < n; i++) {
                dfs(i, 0, Integer.MIN_VALUE, grid);
            }
            for (int i = 1; i < m; i++) {
                dfs(0, i, Integer.MIN_VALUE, grid);
            }
            return res;
        }

        private void dfs(int x, int y, int sum, List<List<Integer>> grid) {
            if(x >= n || y >= m) return;
            res = Math.max(res, sum);
            for (int i = x+1; i < n; i++) {
                dfs(i, y, grid.get(y).get(i) - grid.get(y).get(x), grid);
            }
            for (int i = y+1; i < m; i++) {
                dfs(x, i, grid.get(i).get(x) - grid.get(y).get(x), grid);
            }
        }
    }
}
