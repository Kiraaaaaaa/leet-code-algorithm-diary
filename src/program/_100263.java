package program;

public class _100263 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.sumOfTheDigitsOfHarshadNumber(18);
        System.out.println(res);
    }
    static class Solution {
        public int sumOfTheDigitsOfHarshadNumber(int x) {
            int sum = 0;
            for(int i=x; i>0; i/=10) sum += i%10;
            return x%sum==0?sum:-1;
        }
    }
}
