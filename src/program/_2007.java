package program;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _2007 {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int[] res = solution.findOriginalArray_1(new int[]{4,4,4,4});
        for (int re : res) {
            System.out.println(re);
        }
    }
    static class Solution {
        //方法1.排序+队列，将遍历过程中将一倍数加入结果集，二倍数加入队列，如果遍历到的数在队列中存在则队列删除该数
        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;
            int index = 0; //结果集下标
            int[] res = new int[n / 2];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            Arrays.sort(changed);
            for (int i : changed) {
                if(!queue.isEmpty()){ //如果队列中存在需要比较的二倍数就去比较
                    if(queue.peek() < i){ //如果队列中待比较的二倍数都比目前一倍数还小，那么原数组就肯定不存在该二倍数
                        return new int[0];
                    }
                    if(queue.peek() == i){ //如果匹配上了，就从队列中删除该二倍数，准备遍历下一个数
                        queue.pop();
                        continue;
                    }
                }
                if(index == res.length) return new int[0]; //如果结果集下标超过长度，说明队列已经存了太多待比较的二倍数，此时数组长度已过半，原数组肯定不是双倍数组
                res[index++] = i; //将一倍数加入结果集
                queue.add(i * 2); //将该一倍数的二倍数加入队列准备和下一个数比较
            }
            return res;
        }
        //方法2.暴力查找
        public int[] findOriginalArray_1(int[] changed) throws InterruptedException {
            int n = changed.length;
            int index = 0;
            int[] res = new int[n / 2];
            boolean[] vis = new boolean[n]; //标记坐标是否被抵消过
            Arrays.fill(vis, false);
            Arrays.sort(changed);
            for (int i = 0; i < changed.length; i++) {
                if(vis[i]) continue;
                boolean find = false;
                for (int j = i+1; j < changed.length; j++) {
                    if(changed[i] * 2 == changed[j] && !vis[j]){
                        vis[j] = true;
                        find = true;
                        break;
                    }
                }
                if(!find) return new int[0];
                res[index++] = changed[i]; //将一倍数加入结果集
            }
            return res;
        }
    }
}
