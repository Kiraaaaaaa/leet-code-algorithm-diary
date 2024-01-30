package program;

import java.util.ArrayList;
import java.util.List;

public class _1208 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.equalSubstring("krrgw", "zjxss", 19);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.滑动窗口模板
        public int equalSubstring(String s, String t, int maxCost) {
            int l = 0, r = 0; //区间内左指针，区间内右指针
            int N = s.length();
            int max = 0; //记录最大长度
            int sum = 0; //记录当前区间内差值和
            while(r < N){ //r的右指针右移，r指针占移动主导，拖动着l右移
                sum += Math.abs(s.charAt(r) - t.charAt(r)); //计算当前区间内差值和sum
                while(sum > maxCost){ //当差值和大于maxCost时，左指针右移
                    sum -= Math.abs(s.charAt(l) - t.charAt(l)); //sum减去之前加上的差值和
                    l++;
                }
                max = Math.max(max, r - l + 1); //如果区间差值和合理，更新最大长度
                r++; //r右移
            }
            return max;
        }
    }
}
