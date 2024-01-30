package program;

import java.util.ArrayList;
import java.util.List;

public class _2859 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(5);
        list.add(2);
        int res = solution.sumIndicesWithKSetBits(list, 1);
        System.out.println(res);
    }
    public static class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                if(Integer.bitCount(i) == k) sum += nums.get(i);
            }
            return sum;
        }
    }
}
