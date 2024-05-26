package program;

public class _2105 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minimumRefill(new int[]{1,2,4,4,5}, 6, 5);
        System.out.println(res);
    }
    public static class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int n = plants.length;
            int a = capacityA;
            int b = capacityB;
            int res = 0;
            for (int i = 0, j = n - 1; i <= j; i++, j--) {
                if (i == j) { //如果相遇
                    if(a < plants[i] && b < plants[i]) res++; //并且都没有水足够浇花了，则答案+1
                    continue;
                }
                if(a < plants[i]){ //如果爱丽丝剩余水不够浇花，则重装一次水
                    a = capacityA;
                    res++;
                }
                if(b < plants[j]){ //如果鲍勃剩余水不够浇花，则重装一次水
                    b = capacityB;
                    res++;
                }
                a -= plants[i]; //爱丽丝减去当前浇花需要的水量
                b -= plants[j]; //鲍勃减去当前浇花需要的水量
            }
            return res;
        }
    }
}
