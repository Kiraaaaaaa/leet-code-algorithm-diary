package program;

import java.util.*;

public class _2368 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5});
        System.out.println(res);
    }
    public static class Solution {
        ArrayList<Integer>[] map;
        HashSet<Integer> set;
        //方法1.dfs
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            map = new ArrayList[n]; // 保存所有节点的邻接节点 -> [该点序号, <其可访问的点集合>]
            set = new HashSet<>(); // 保存故障节点和目前访问过的节点
            for (int i = 0; i < map.length; i++) { //初始化邻接表
                map[i] = new ArrayList<>();
            }
            for (int i : restricted) set.add(i);
            for (int[] edge : edges) { // 构建可达节点的映射
                map[edge[0]].add(edge[1]);
                map[edge[1]].add(edge[0]);
            }
            dfs(0);
            return set.size() - restricted.length; // 减去故障节点数则是最大可达节点数
        }
        private void dfs(int i) {
            set.add(i); // 将访问过的节点添加到集合中
            for (Integer num : map[i]) {
                if(!set.contains(num)){
                    dfs(num); // 只要没有访问过且不是故障节点，就继续访问下去
                }
            }
        }
    }

}
