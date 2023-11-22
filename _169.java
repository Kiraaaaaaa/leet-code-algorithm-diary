package 刷题;

import java.util.*;

public class _169 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int i = solution.majorityElement(nums);
        System.out.println(i);
    }
    public static class Solution{
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            //先用哈希表存储每个数字对应的出现次数
            for (int num : nums) {
                if(map.containsKey(num)){
                    Integer val = map.get(num);
                    map.put(num, val+1);
                }else{
                    map.put(num, 1);
                }
            }
            int maxValue = Integer.MIN_VALUE, maxKey = 0;
            //擂台方式找出最大次数对应的数字
            for (int num : nums) {
                if(map.get(num) > maxValue){
                    maxValue = map.get(num);
                    maxKey = num;
                }
            }
            return maxKey;
        }
    }
}
