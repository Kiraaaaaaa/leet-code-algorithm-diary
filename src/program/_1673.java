package program;

import java.util.ArrayDeque;
import java.util.HashSet;

public class _1673 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4);
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static class Solution {
        //方法1.单调栈
        //思路：由于寻找最小序列，所以采用单调栈来保证，因为栈内序列总是最小的
        //比较栈顶元素和当前元素，如果栈顶元素大于当前元素，则出栈，直到栈顶元素小于当前元素。前提是栈内还可以添加的元素数量小于数组剩余数量，否则是填不满栈的
        //栈内元素除-1外保存的就是一个递增序列，出栈然后倒序保存即可
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.addFirst(-1); //栈内添加一个假元素，方便代码运行
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                //比较栈顶元素和当前元素，如果栈顶元素大于当前元素，则出栈，直到栈顶元素小于当前元素。前提是栈内还可以添加的元素数量小于数组剩余数量，否则是填不满栈的
                while (num < stack.peek() && k - stack.size() + 1 < n - i) {
                    stack.pop();
                }
                //如果栈内元素个数小于k，才需要入栈，如果栈内元素一直递增，我们只需要保留最小的前几位即可
                if(stack.size() < k + 1){
                    stack.addFirst(num);
                }
            }
            int[] res = new int[k];
            //由于栈内存放的是倒序，所以需要倒序输出。
            while(k > 0){
                res[--k] = stack.pop();
            }
            return res;
        }
    }
}
