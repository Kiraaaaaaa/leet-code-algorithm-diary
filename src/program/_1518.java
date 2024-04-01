package program;

public class _1518 {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.numWaterBottles   (9, 3);
        System.out.println(res);
    }
    static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int res = numBottles, cnt = 0, c = 0;
            while(numBottles >= numExchange){
                c = numBottles/numExchange;
                cnt += c;
                numBottles = numBottles%numExchange+c;
            }
            return res + cnt;
        }
    }
}
