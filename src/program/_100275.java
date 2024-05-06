package program;

import java.util.HashMap;

public class _100275 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minimumOperationsToMakeKPeriodic("ppp", 1);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.哈希表
        //思路：字符串分割成n/k个k长度的字符串，用hashmap去记录各自的出现次数。得到最多的出现次数max，用n/k-max即需要粘贴的次数。
        public int minimumOperationsToMakeKPeriodic(String word, int k) {
            int n = word.length();
            int max = 1; //记录最多的重复次数
            HashMap<String, Integer> map = new HashMap<>(); //记录字符串的重复次数
            for (int i = 0; i < n; i+=k) {
                String s = word.substring(i, i+k); //取出当前字符串
                if(map.containsKey(s)){ //如果当前字符串有记录
                    Integer count = map.get(s)+1; //拿到出现次数
                    map.put(s, map.get(s)+1); //更新出现次数
                    max = Math.max(max, count); //比较最大出现次数
                }else{
                    map.put(s, 1); //第一次记录该字符串出现次数
                }
                // 上面if-else也可以这样写
                // Integer count = map.putIfAbsent(s, 1); //第一次则记录1并返回null。第二次因为存在key，所以将返回原本的value
                // if(count != null){ //否则去取出出现次数
                //     map.put(s, ++count);
                //     max = Math.max(max, count);
                // }

                // 上面if-else还可以这样写
                // map.put(s, map.getOrDefault(s, 0) + 1);
                // max = Math.max(max, map.get(s));
            }
            return n/k-max; //最大粘贴次数-已出现次数=需要粘贴的次数
        }
    }
}
