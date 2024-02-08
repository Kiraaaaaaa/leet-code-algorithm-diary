package program;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1481 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 0);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.哈希表记录每个元素出现的个数，出现个数从小到大进行移除，直到k步被用完或不够
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1); //保存每个数字出现的次数
            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet()); //转为List方便根据value排序
            list.sort(Comparator.comparingInt(Map.Entry::getValue)); //根据value从小到大排序
            while(--k >= 0){
                Integer value = list.get(0).getValue(); //取出现次数最小的value
                if(value == 1) list.remove(0); //如果出现次数为1，删除该数字
                else list.get(0).setValue(value - 1); //否则出现次数减1
            }
            return list.size(); //统计残存的数字
        }
    }
}
