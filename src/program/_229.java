package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _229 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.majorityElement(new int[]{1,2});
        System.out.println(list);
    }
    public static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() > nums.length/3) list.add(entry.getKey());
            }
            return list;
        }
    }
}
