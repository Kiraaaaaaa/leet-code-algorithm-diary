package program;

import java.util.ArrayList;

public class _1492 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.kthFactor(4, 4   );
        System.out.println(res);
    }
    public static class Solution {
        public int kthFactor(int n, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if(n % i == 0) list.add(i);
            }
            System.out.println(list);
            return list.size() < k ? -1 : list.get(k - 1);
        }
    }
}
