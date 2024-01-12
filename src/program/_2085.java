package program;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class _2085 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countWords(new String[]{"leetcode","is","amazing","as","is"}, new String[]{"amazing","leetcode","is"}));
    }
    public static class Solution {
        public int countWords(String[] words1, String[] words2) {
            HashMap<String, Integer> mapA = new HashMap<>();
            HashMap<String, Integer> mapB = new HashMap<>();
            int res = 0;
            int len = Math.max(words1.length, words2.length);
            for (int i = 0; i < len; i++) {
                if(i<words1.length) mapA.put(words1[i], mapA.getOrDefault(words1[i], 0)+1);
                if(i<words2.length) mapB.put(words2[i], mapB.getOrDefault(words2[i], 0)+1);
            }
            for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
                if(entry.getValue() == 1 && mapB.containsKey(entry.getKey()) && mapB.get(entry.getKey()) == 1) ++res;
            }
            return res;
        }
    }
}
