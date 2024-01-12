package program;

public class _134 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,0,2,1,1,2};
        int res = solution.canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1});
        System.out.println(res);
    }
    public static class Solution{
        //解法1.暴力模拟
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int N = gas.length;
            for (int i = 0; i < gas.length; i++) {
                int j = i; //尝试行驶时的坐标
                int remain = gas[i]; //剩余油量
                while(remain >= cost[j]){
                    //行驶到下一个加油站时的剩余油量
                    remain = remain - cost[j] + gas[(j+1)%N];
                    j = (j+1)%N; //更新行驶坐标
                    //由于j已经在尝试行驶中了，如果再次和出发点i相遇说明可以到达出发点，返回出发点的下标
                    if(i == j) return i;
                }

                //优化点1.如果j小于i，说明永远都无法到达出发点
                if(j < i){
                    return -1;
                }
                //优化点2.如果i最多只能走到j的位置，下次直接从j+1位置处开始即可
                i = j;
            }
            return -1;
        }
    }
}
