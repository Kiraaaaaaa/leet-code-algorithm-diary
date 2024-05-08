package program;

import java.util.HashSet;
import java.util.PriorityQueue;

public class _264 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.nthUglyNumber_1(10);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.（超时）不断整除2,3,5
        public int nthUglyNumber(int n) {
            int count = 0; //已经被记录的丑数个数
            int index = 0; //枚举的数字
            int temp; //用来判断是否为丑数的复制数字
            int[] nums = {2, 3, 5};
            while(true){
                index++;
                temp = index;
                for (int num : nums) {
                    while(temp%num == 0) temp/=num;
                }
                if(temp == 1){
                    count++;
                    if(count == n) return index;
                }
            }
        }

        //方法2.将数字x的2,3,5倍数放入堆中，并在此期间用set去重
        public int nthUglyNumber_1(int n) {
            int[] nums = {2,3,5}; //因子
            PriorityQueue<Long> queue = new PriorityQueue<>();
            HashSet<Long> set = new HashSet<>();
            queue.add(1L);
            set.add(1L);
            for (int i = 0; i < n; i++) { //执行n次后拿出的第一个数就是答案
                long x = queue.poll(); //取出当前堆中最小的数x
                if(i == n-1) return (int)x;
                for (int num : nums) {
                    long t = x * num; //拿到其倍数
                    if(!set.contains(t)){ //只要该倍数没有遇到过
                        queue.add(t); //添加进堆
                        set.add(t); //记录遇到过该数
                    }
                }
            }
            return -1;
        }
    }
}
