package program;

public class _2739 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.distanceTraveled_1(9, 10);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.模拟
        public int distanceTraveled(int mainTank, int additionalTank) {
            int res = 0;
            while(mainTank / 5 > 0){ //以5为一个批次进行模拟，主存达到5就消耗
                mainTank -= additionalTank > 0 ? 4 : 5; //看副存是否有备用油，有则消耗4，否则消耗5，因为有油就会给主存加1，所以主存本批次要-4
                additionalTank -= 1; //模拟副存消耗1
                res += 50; //每批次能跑50
            }
            return res + mainTank * 10; //主存不足以再跑下一批次了就加上其剩余的主存
        }

        //方法2.数学计算
        //根据主存我们就能知道能从副存拿多少油->(mainTank - 1) / 4)，先假设副存一直都有油，如果mainTank为9，那么计算结果就是2，我们可以再拿2个油
        //现在再取考虑副存能不能提供我们要拿的油->Math.min(additionalTank, 我们要拿的油)，所以够我们就拿，如果不够我们的需求就拿光所有副存的油
        //最后就是 主存的油+我们能拿的油 乘以10 即可
        public int distanceTraveled_1(int mainTank, int additionalTank) {
            return (mainTank + Math.min(additionalTank, (mainTank - 1) / 4)) * 10;
        }
    }
}
