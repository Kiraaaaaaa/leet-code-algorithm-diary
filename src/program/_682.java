package program;

import java.util.ArrayDeque;
import java.util.Deque;

public class _682 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int rob = solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.println(rob);
    }
    public static class Solution{
        public int calPoints(String[] operations) {
            int total = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            for (String operation : operations) {
                if(operation.equals("C")){
                    stack.pop();
                }else if(operation.equals("D")){
                    stack.push(stack.peek()*2);
                }else if(operation.equals("+")){
                    Integer second = stack.pop();
                    Integer first = stack.pop();
                    stack.push(first);
                    stack.push(second);
                    stack.push(first+ second);
                }else{
                    stack.push(Integer.valueOf(operation));
                }
            }
            while(!stack.isEmpty()){
                total += stack.pop();
            }
            return total;
        }
    }
}
