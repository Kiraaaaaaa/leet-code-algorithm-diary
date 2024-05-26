package program;

import java.util.HashSet;

public class _2391 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2, 4, 3});
        System.out.println(res);
    }
    public static class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            int res = 0;
            HashSet<String> set = new HashSet<>(); //保存目前需要被计算行驶时间的物品类型
            for (int i = garbage.length - 1; i >= 0; i--) {
                String s = garbage[i];
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j); //当前收集物
                    res++; //收集物品+1
                    set.add(String.valueOf(c)); //当前物品类型开始纳入行驶时间计算计划
                }
                if(i != 0) res += travel[i-1] * set.size(); //该房子的物品种类数量*从上一个房子到该房子的行驶时间=该房子收集完一共花费时间
            }
            return res;
        }
    }
}
