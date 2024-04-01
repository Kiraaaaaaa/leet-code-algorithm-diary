package program;

import java.util.LinkedList;
import java.util.Queue;

public class _225 {
    public static void main(String[] args) {

    }
    class MyStack {
        Queue<Integer> main; //存倒序元素
        Queue<Integer> minor; //存正序元素
        public MyStack() {
            main = new LinkedList<>();
            minor = new LinkedList<>();
        }
        public void push(int x) {
            minor.offer(x);
            while(!main.isEmpty()){
                minor.offer(main.poll());
            }
            //此时main为空，交换两个队列
            Queue<Integer> temp = main;
            main = minor;
            minor = temp;
        }
        public int pop() {
            return main.poll();
        }
        public int top() {
            return main.peek();
        }
        public boolean empty() {
            return main.isEmpty();
        }
    }
}
