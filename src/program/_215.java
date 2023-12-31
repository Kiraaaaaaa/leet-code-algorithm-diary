package program;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _215 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findKthLargest_1(new int[]{3,2,1,5,6,4},2);
        System.out.println(res);
    }
    public static class Solution {
        //方法1：优先队列
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                integers.add(num);
            }
            while(--k>0){
                integers.poll();
            }
            return integers.poll();
        }

        //方法2：stream流
        public int findKthLargest_1(int[] nums, int k) {
            int res = Arrays.stream(nums).sorted().skip(nums.length - k).min().getAsInt();
            return res;
        }
    }
}
