package program;

public class _258 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.addDigits_1(38);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.模拟不断相加，直到和小于10为止
        public int addDigits(int num) {
            while(num>=10){ //只要和大于等于10，这说明还能相加
                int sum = 0; //每位相加之和
                for(;num>0;num/=10){
                    sum += num%10; //计算各位数和
                }
                num = sum; //更新num为和
            }
            return num;
        }
        //方法2.递归，每次将数除10以后相加除之前的最后一位，直到和小于10为止
        public int addDigits_1(int num) {
            if(num < 10) return num;
            return addDigits_1(num/10 + num%10);
        }
    }
}
