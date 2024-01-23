package program;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _2501 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestSquareStreak(new int[]{3,9,81,6561});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.枚举
        public int longestSquareStreak(int[] nums) {
            Set<Long> set = Arrays.stream(nums).mapToObj(Long::valueOf).collect(Collectors.toSet());
            int max = 0;
            for (long num : nums) {
                int cnt = 0;
                while(set.contains(num)){
                    ++cnt;
                    num *= num;
                }
                max = Math.max(max, cnt);
            }
            return max <= 1 ? -1 : max;
        }
        //方法2.记忆化搜索
    }
}
