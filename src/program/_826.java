package program;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class _826 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82});
        System.out.println(res);
    }
    public static class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            int m = worker.length;
            int[][] map = new int[n][2];
            int res = 0;
            for (int i = 0; i < n; i++) {
                map[i][0] = difficulty[i];
                map[i][1] = profit[i];
            }
            //利润从大到小排序
            Arrays.sort(map, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(map[j][0] <= worker[i]){
                        res += map[j][1];
                        break;
                    }
                }
                System.out.println(res);
            }
            return res;
        }
    }
}
