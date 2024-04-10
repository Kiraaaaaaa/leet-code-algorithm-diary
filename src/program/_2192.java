    package program;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.List;

    public class _2192 {
    public static void main(String[] args) {
        Solution so = new Solution();
        List<List<Integer>> list = so.getAncestors_1(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}});
        System.out.println(list);
    }
    static class Solution {
        //方法1.我的错误解法（中途加入的点无法再次加入到之前的答案中）
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            HashSet[] sets = new HashSet[n]; //记录各个节点的祖先节点集合
            for (int i = 0; i < sets.length; i++) sets[i] = new HashSet<Integer>(); //初始化空的集合
            for (int[] edge : edges) {
                sets[edge[1]].add(edge[0]); //当前节点的祖先集合加入父节点
                for (Object num : sets[edge[0]]) sets[edge[1]].add(num); //当前节点的祖先集合加入父节点的祖先节点集合
            }
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < n; i++){ //构造返回集合
                lists.add(new ArrayList<>(sets[i]));
            }
            return lists;
        }
        //方法2.反向建图，DFS
        public List<List<Integer>> getAncestors_1(int n, int[][] edges) {
            ArrayList<Integer>[] map = new ArrayList[n];
            Arrays.setAll(map, i -> new ArrayList<>());
            for (int[] edge : edges) {
                map[edge[1]].add(edge[0]); //构建反向图
            }
            ArrayList<Integer>[] ans = new ArrayList[n]; //存储答案
            Arrays.setAll(ans, i -> new ArrayList<>());
            boolean[] vis = new boolean[n]; //记录当前节点是否访问过
            for (int i = 0; i < n; i++) {
                Arrays.fill(vis, false); //每次遍历完一个节点的祖先节点就清空一次访问记录
                dfs(i, map, vis);
                vis[i] = false; //取消掉当前节点的访问记录(因为需要的是祖先节点)
                for (int j = 0; j < n; j++) {
                    if(vis[j]){
                        ans[i].add(j); //如果当前节点访问过，说明当前节点是祖先节点
                    }
                }
            }
            return Arrays.asList(ans);
        }

        private void dfs(int i, ArrayList<Integer>[] map, boolean[] vis) {
            vis[i] = true; //标记当前节点已被访问过
            for (Integer num : map[i]){
                if(!vis[num]){ //如果当前节点的该父节点没有被访问过，就继续遍历
                    dfs(num, map, vis);
                }
            }
        }
    }
}
