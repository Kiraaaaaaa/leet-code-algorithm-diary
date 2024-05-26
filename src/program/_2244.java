package program;

import java.util.ArrayDeque;
import java.util.HashMap;

public class _2244 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minimumRounds(new int[]{2,3,3});
        System.out.println(res);
    }
    public static class Solution {
        public int minimumRounds(int[] tasks) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tasks.length; i++) {
                map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            }
            for (Integer i : map.keySet()) {
                Integer times = map.get(i);
                if(times == 1) return -1;
                res +=(times - 1) / 3 + 1;
            }
            return res;
        }
    }
}
