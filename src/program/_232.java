package program;

import java.util.*;

public class _232 {
    public static void main(String[] args) {
    }
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
        public void push(int x) {
            if(!stack2.isEmpty()) out2in();
            stack1.push(x);
            in2out();
        }
        public int pop() {
            return stack2.pop();
        }
        public int peek() {
            return stack2.peek();
        }
        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
        public void in2out(){
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        public void out2in(){
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }
    }
}
