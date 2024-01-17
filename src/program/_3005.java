package program;

import java.util.HashMap;

public class _3005 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxFrequencyElements_1(new int[]{1,2,2,3,1,4});
        System.out.println(res);
    }
    public static class Solution {

        //方法1.常规解法，哈希表存储每个元素出现的次数，然后遍历统计出现次数最大的元素个数
        public int maxFrequencyElements(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxTimes = 1, res = 0;
            for (int num : nums){ // 统计每个元素出现的次数
                map.put(num, map.getOrDefault(num, 0)+1);
                maxTimes = Math.max(map.get(num), maxTimes);
            }
            for (Integer times : map.values()) { // 统计出现次数最大的元素个数
                if(times == maxTimes) res += times;
            }
            return res;
        }
        //方法2.只需一次遍历，在遍历过程中不断维护最大频率和最大元素个数
        public int maxFrequencyElements_1(int[] nums) {
            int[] count = new int[101]; //数字的出现次数(频率)
            int maxTimes = 1, res = 0; //最大频率和拥有其频率的元素个数
            for (int num : nums) {
                ++count[num]; //先为该元素的出现次数加1
                if(count[num] > maxTimes){ //如果该元素的出现次数大于最大频率
                    maxTimes = count[num]; //先更新最大频率
                    res = maxTimes; //由于出现了新的最大频率，所以除该数外，此前出现的所有数的个数都被清0，最终个数变为当前数的频率
                }else if(count[num] == maxTimes){ //如果该元素的出现次数等于最大频率
                    res += maxTimes; //说明该数是满足最大频率的元素之一，最终个数添加上最大频率
                }
            }
            return res;
        }
    }
}
