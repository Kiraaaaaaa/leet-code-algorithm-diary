package program;

import java.util.PriorityQueue;

public class LCP_30 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.magicTower(new int[]{100,100,100,-250,-60,-140,-50,-50,100,150});
        System.out.println(res);
    }
    public static class Solution {
        public int magicTower(int[] nums) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if(sum < 0) return -1; //先计算总血量是否大于0，如果不满足则返回-1
            int ans = 0;
            long hp = 1;
            PriorityQueue<Integer> queue = new PriorityQueue<>(); //优先队列存放负数
            for (int num : nums) {
                if(num < 0) queue.offer(num); //如果是减血，则该数加入队列
                hp += num; //得到当前血量
                if(hp < 1){ //如果当前血量小于1，需要补充血量
                    hp -= queue.poll(); //需要补充的血量即为队列中绝对值最大的血量，因为我们需要的是交换最小次数，所以能加就加
                    ans += 1; //撤销一次就是一次交换
                }
            }
            return ans;
        }
    }
}
