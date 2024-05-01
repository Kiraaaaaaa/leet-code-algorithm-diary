package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _1018 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Boolean> res = solution.prefixesDivBy5(new int[]{1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0});
        System.out.println(res);
    }

    public static class Solution {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            ArrayList<Boolean> res = new ArrayList<>();
            long x = 0;
            for (int num : nums) {
                x = (x*2 + num) % 5; // 不能将(x*2 + num)计算结果存储，会溢出。由于5是一个特殊值，我们只需要知道上个数的个位是不是奇数即可，所以这样是可以的
                res.add(x == 0); // 如果x==0，则能被5整除
            }
            return res;
        }
    }
}
