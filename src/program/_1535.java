package program;

public class _1535 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.getWinner(new int[]{1,25,35,68,42,70}, 3);
        System.out.println(res);
    }
    public static class Solution {
        public int getWinner(int[] arr, int k) {
            int x = arr[0]; // x代表当前最大数
            int count = 0; // count用于记录该最大数连胜次数
            for (int i = 1; i < arr.length && count < k; i++) { // 如果连胜次数超过k次，则直接结束
                if(arr[i] > x){ //如果当前数大于x，则更新x，并且将count置为0
                    x = arr[i];
                    count = 0;
                }
                count++; // 连胜加一次
            }
            return x;
        }
    }
}
