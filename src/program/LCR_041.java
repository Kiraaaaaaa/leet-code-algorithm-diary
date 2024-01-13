package program;

import java.util.ArrayDeque;

public class LCR_041 {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        double a = movingAverage.next(1);
        double b = movingAverage.next(10);
        double c = movingAverage.next(3);
        double d = movingAverage.next(5);
        System.out.println(a+" "+b+" "+c+" "+d);
    }
    public static class MovingAverage {
        int size;
        double sum;
        ArrayDeque<Integer> deque;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            sum = 0;
            deque = new ArrayDeque<>();
        }
        public double next(int val) {
            if(deque.size() == size){
                sum -= deque.poll();
            }
            deque.add(val);
            sum += val;
            return sum/deque.size();
        }
    }
}
