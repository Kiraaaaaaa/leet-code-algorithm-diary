package program;

public class _1184 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.distanceBetweenBusStops(new int[]{1,2,3,4}, 3, 0);
        System.out.println(res);
    }
    static class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int step_1 = 0, step_2 = 0;
            for(int i = start; i != destination; i = (i + 1) % distance.length) step_1 += distance[i]; //顺时针走
            for(int i = (start - 1 + distance.length) % distance.length; i != destination - 1; i = start < destination ? (i - 1 + distance.length) % distance.length : i - 1) step_2 += distance[i]; //逆时针走
            return Math.min(step_1, step_2);
        }
    }
}
