package program;

public class _2520 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countDigits_1(7);
        System.out.println(i);
    }
    public static class Solution {
        //方法1.常规解法
        public int countDigits(int num) {
            int res = 0;
            for(int n = num; n > 0; n /= 10){
                if(num % (n % 10) == 0) ++res;
            }
            return res;
        }
        //方法2.strema流
        public int countDigits_1(int num) {
            int count = (int) String.valueOf(num).chars().filter(c -> num % ( c - '0') == 0).count();
            return count;
        }
    }
}
