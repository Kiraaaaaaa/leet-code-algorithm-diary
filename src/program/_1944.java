package program;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class _1944 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});
        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     * 这是一道经典的单调栈问题
     * 思路：从右往左遍历数组，如果当前数比栈顶元素高，则栈顶元素出栈，并将当前数的可见人数+1，循环这个操作直到当前数小于栈顶元素或栈为空，如果栈还不为空，则将当前数的可见人数+1
     */
    public static class Solution{
        public int[] canSeePersonsCount(int[] heights) {
            int[] res = new int[heights.length];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            //从后往前遍历数组
            for(int i = heights.length-1; i >= 0; i--){
                //当栈不为空，且当前身高大于栈顶元素，则栈顶元素出栈
                while(!stack.isEmpty() && heights[i] > stack.peek()){
                    stack.pop();
                    ++res[i]; //出栈多少次则代表该数能看到多少人
                }
                //如果栈不为空，说明还有比自己高的，那么能看到的人数还得+1
                if(!stack.isEmpty()){
                    ++res[i];
                }
                stack.push(heights[i]); //将该数入栈
            }
            return res;
        }
    }
}
