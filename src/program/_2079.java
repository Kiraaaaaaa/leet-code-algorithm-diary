package program;

public class _2079 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.wateringPlants(new int[]{1,1,1,8,2,3}, 4);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.模拟，（用例是每个位置只用返回一次就能浇完水，而没有需要往返多次的情况，坑死我了
        public int wateringPlants(int[] plants, int capacity) {
            int num = capacity;
            int res = 0;
            for (int i = 0; i < plants.length; i++) {
                if(num < plants[i]){
                    res += i * 2;
                    num = capacity;
                }
                res++;
                num -= plants[i];
            }
            return res;
        }
    }
}
