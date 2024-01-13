package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _1122 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6});
        Arrays.stream(res).forEach(System.out::println);
    }

    public static class Solution {
        //方法1
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            //1.先对数组升序排序
            Arrays.sort(arr1);
            int[] res = new int[arr1.length];
            //2.保存共有的元素与出现次数
            for (int i : arr2) {
                for (int j : arr1) {
                    if(i == j) map.put(i, map.getOrDefault(i, 0) + 1);
                }
            }
            int startIndex = 0;
            //3.根据元素出现次数，将元素依次放入结果数组中
            for (int i : arr2) {
                Integer count = map.get(i);
                for (Integer index = startIndex; index < startIndex + count; index++) {
                    res[index] = i;
                }
                startIndex += count;
            }
            //4.将剩余元素放入结果数组中(已排序)
            for (int i : arr1) {
                if(!map.containsKey(i)) res[startIndex++] = i;
            }
            return res;
        }
        //方法2.todo
        public int[] relativeSortArray_1(int[] arr1, int[] arr2) {
            return null;
        }
    }
}

