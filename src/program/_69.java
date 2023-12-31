package program;

public class _69 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.mySqrt_2(8);
        System.out.println(res);
    }
    public static class Solution {
        public int mySqrt_1(int n) {
            //暴力枚举n以内的每个数
            for (int i = 0; i <= n; i++) {
                //下一个可能值
                long next = i+1;
                //如果当前值的平方小于等于n && 下一个值的平方大于n，则代表找到
                if(i*i<=n && next*next>n){
                    return i;
                }
            }
            return 0;
        }

        //二分法
        public int mySqrt_2(int n) {
            int l = 0, r = n, ans = -1;
            while (l <= r) {
                //得到一个中间值mid
                int mid = l + (r - l) / 2;
                //如果mid的平方小于等于n，则mid的右边可能是答案，继续向右寻找
                if ((long) mid * mid <= n) {
                    //由于不确定是不是答案，所以先记下来，直到最后一个赋值
                    ans = mid;
                    //向右寻找
                    l = mid + 1;
                } else {
                    //答案在mid的左边，向左寻找
                    r = mid - 1;
                }
            }
            return ans;
        }
    }
}
