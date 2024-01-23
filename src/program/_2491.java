package program;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class _2491 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.dividePlayers(new int[]{1,1,1,1});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.双指针
        public long dividePlayers(int[] skill) {
            Arrays.sort(skill);
            int l = 0, r = skill.length - 1;
            int sum = skill[l] + skill[r];
            long res = 0;
            while (l < r) {
                if(sum != skill[l] + skill[r]) return -1;
                sum = skill[l] + skill[r];
                res += skill[l] * skill[r];
                l++;
                r--;
            }
            return res;
        }
    }
}
