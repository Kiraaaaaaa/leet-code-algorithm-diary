package program;

import java.util.*;

public class _2225 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.findWinners_1(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.哈希表+Set集合
        public List<List<Integer>> findWinners(int[][] matches) {
            int n = matches.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            // sets[0]:没有输过的玩家，sets[1]：输过一次玩家
            Set[] sets = new HashSet[]{new HashSet<>(), new HashSet()};
            // 1.记录输过的玩家，key：玩家，value：输过几次
            for (int i = 0; i < n; i++)  map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
            // 2.遍历matches，寻找没有输过的玩家
            for (int i = 0; i < n; i++) if(!map.containsKey(matches[i][0])) sets[0].add(matches[i][0]);
            // 3.遍历map，寻找只输过一次的玩家
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) if(entry.getValue() == 1) sets[1].add(entry.getKey());
            List<List<Integer>> res = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
            res.get(0).addAll(sets[0]);
            res.get(1).addAll(sets[1]);
            res.get(0).sort((a,b)->a-b);
            res.get(1).sort((a,b)->a-b);
            return res;
        }

        //方法2.map记录下所有玩家的输掉次数
        public List<List<Integer>> findWinners_1(int[][] matches) {
            int n = matches.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            // sets[0]:没有输过的玩家，sets[1]：输过一次玩家
            Set[] sets = new HashSet[]{new HashSet<>(), new HashSet()};
            // 1.所有玩家输过的次数，key：玩家，value：输过几次
            for (int i = 0; i < n; i++){
                map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
                map.put(matches[i][0], map.getOrDefault(matches[i][0], 0)); // 如果该玩家没有输过，则value为0，否则不变
            }
            // 3.遍历map，记录没有输过的玩家和只输过一次的玩家
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                if(entry.getValue() == 1){
                sets[1].add(entry.getKey());
                }else if(entry.getValue() == 0) sets[0].add(entry.getKey());
            List<List<Integer>> res = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
            res.get(0).addAll(sets[0]);
            res.get(1).addAll(sets[1]);
            res.get(0).sort((a,b)->a-b);
            res.get(1).sort((a,b)->a-b);
            return res;
        }
    }
}
