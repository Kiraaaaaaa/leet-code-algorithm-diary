package program;

import java.util.*;
import java.util.stream.Collectors;

public class _347 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Arrays.stream(res).forEach(c->{
            System.out.print(c+" ");
        });
    }
    public static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0)+1);
            return map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(k).mapToInt(Map.Entry::getKey).toArray();
        }
    }
}
