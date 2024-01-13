package program;

import java.util.ArrayDeque;

public class _933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        int a = recentCounter.ping(1);
        int b = recentCounter.ping(100);
        int c = recentCounter.ping(3001);
        int d = recentCounter.ping(3002);
        System.out.println(a+" "+b+" "+c+" "+d);
    }
    public static class RecentCounter {
        ArrayDeque<Integer> deque;
        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.add(t);
            while(t-deque.peek()>3000) deque.pop();
            return deque.size();
        }
    }
}
