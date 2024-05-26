package program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _100313 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.queryResults(4, new int[][]{{0,1},{1,2},{2,2},{3,4},{4,5}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static class Solution {

        //方法1.两张哈希表，一张表存储每个球当前的颜色，一张表存储每个颜色当前的球数
        public int[] queryResults(int limit, int[][] queries) {
            int n = queries.length;
            int[] res = new int[n];
            HashMap<Integer, Integer> bollMap = new HashMap<>(); // 存储每个球的颜色
            HashMap<Integer, Integer> colorMap = new HashMap<>(); // 存储每个颜色的球数
            for (int i = 0; i < n; i++) {
                int[] q = queries[i];
                if(bollMap.containsKey(q[0])){ //如果修改的球是以前修改过的球
                    Integer oldColor = bollMap.get(q[0]); // 获取之前球的颜色
                    Integer oldColorNum = colorMap.get(oldColor); // 获取之前该颜色的球数
                    if(oldColorNum == 1) colorMap.remove(oldColor); // 如果该颜色的球只有当前这个，则删除该颜色
                    else colorMap.put(oldColor, oldColorNum - 1); // 否则该颜色的球数减1
                }
                bollMap.put(q[0], q[1]); // 修改球颜色
                colorMap.put(q[1], colorMap.getOrDefault(q[1], 0) + 1); // 该颜色的球数+1
                res[i] = colorMap.size();
            }
            return res;
        }
    }
}
