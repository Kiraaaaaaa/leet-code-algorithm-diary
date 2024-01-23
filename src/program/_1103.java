package program;

public class _1103 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.distributeCandies(7, 4);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static class Solution {
        //方法1.循环模拟发糖果
        public int[] distributeCandies(int candies, int num_people) {
            int index = 0; //当前小朋友的编号，index+1则是他能领到的糖果数量
            int[] res = new int[num_people]; //每个人得到的糖果情况
            while(candies > 0){ //只要剩余的糖果大于0说明还没有发完
                res[index%num_people] += candies > index+1 ? index+1 : candies; //或者写成Math.min(index+1, candies)
                candies -= index+1; //发完糖果后，统计一下剩余的糖果数量
                index++; //下一个小朋友
            }
            return res;
        }
    }
}
