package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _2462 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.totalCost(new int[]{1,2,4,1}, 3, 3);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.两个最小堆，分别存储各自最小值。
        public long totalCost(int[] costs, int k, int candidates) {
            long res = 0;
            int n = costs.length;
            if(2 * candidates + k > n){ // 如果在k次循环内能覆盖数组所有的元素，则直接排序，然后取前k个元素相加返回即可。还有个好处，避免了下面的循环模拟过程中出现两区间重合的情况，处理会很麻烦。
                Arrays.sort(costs);
                for (int i = 0; i < k; i++) {
                    res += costs[i];
                }
                return res;
            }
            PriorityQueue<Integer> queueA = new PriorityQueue<>(); // 候选区间A的堆
            PriorityQueue<Integer> queueB = new PriorityQueue<>(); // 候选区间B的堆
            for (int i = 0; i < candidates; i++){ // 初始化候选区间A和B的堆
                queueA.offer(costs[i]);
                queueB.offer(costs[n-i-1]);
            }
            int startA = candidates, startB = n - candidates - 1; // 候选区间A的结束位置和候选区间B的起始位，代表下一个要入队列的坐标
            while(k-- > 0) { // k次雇佣工人
                if (queueA.peek() <= queueB.peek()) { // 从候选区间A中取出最小值
                    res += queueA.poll();
                    queueA.offer(costs[startA++]); // 候选区间A中加入下一个要入队列的坐标
                }else{
                    res += queueB.poll();
                    queueB.offer(costs[startB--]); // 候选区间B中加入下一个要入队列的坐标
                }
            }
            return res;
        }
    }
}
