package program;

import java.util.ArrayDeque;
import java.util.HashSet;

public class _365 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.canMeasureWater(3, 5, 4);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.深度优先搜索
        public boolean canMeasureWater(int x, int y, int z) {
            ArrayDeque<int[]> stack = new ArrayDeque<>(); // 用栈存储杯子x和杯子y的状态
            HashSet<Long> set = new HashSet<>(); // 用集合存储已经访问过的状态
            stack.add(new int[]{0, 0}); // 初始状态，现在两个杯子都没有水
            while(!stack.isEmpty()){
                if(set.contains(hash(stack.peek()))){ // 如果此状态已经访问过，则此状态出栈(避免死循环)
                    stack.pop();
                    continue;
                }
                int[] state = stack.pop(); // 出栈，获取当前两个壶的水量
                set.add(hash(state)); // 计算当前状态的hash值，并放到集合中
                int remain_x = state[0], remain_y = state[1]; // 获取当前x壶和y壶的水量
                if(remain_x == z || remain_y == z || remain_x + remain_y == z){
                    return true; //只要其中一个壶的水量或者两个壶加起来的水量刚好等于目标水量z，则返回true
                }
                // 开始尝试每一种情况(DFS)
                // 将x壶填满
                stack.add(new int[]{x, remain_y});
                // 将y壶填满
                stack.add(new int[]{remain_x, y});
                // 将x壶倒空
                stack.add(new int[]{0, remain_y});
                // 将y壶倒空
                stack.add(new int[]{remain_x, 0});
                // 将x壶的水倒进y壶中，直到把x壶倒空或者把y壶填满
                stack.add(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
                // 将y壶的水倒进x壶中，直到把y壶倒空或者把x壶填满
                stack.add(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
            }
            return false; // 如果每种状态都模拟过，且没有一种状态的水量是刚好等于目标水量z的，则返回false
        }

        // 计算当前状态的hash值，用于判断是否已经访问过
        private Long hash(int[] state) {
            return (long) state[0] * 1000001 + state[1];
        }
    }
}
