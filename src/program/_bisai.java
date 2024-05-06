package program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

//比赛专用
public class _bisai {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minimumOperationsToMakeKPeriodic_1("leetcodeleet", 4);
        System.out.println(res);
    }
    public static class Solution {
        public int minimumOperationsToMakeKPeriodic_1(String word, int k) {
            int n = word.length();
            int max = 1;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i+=k) {
                String s = word.substring(i, i+k);
                if(map.containsKey(s)){
                    Integer count = map.get(s)+1;
                    map.put(s, map.get(s)+1);
                    max = Math.max(max, count);
                }else{
                    map.put(s, 1);
                }
            }
            return n/k-max;
        }
    }
}
