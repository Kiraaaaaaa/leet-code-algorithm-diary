package program;

import java.util.Arrays;

public class _2571 {
    public static void main(String[] args) {
        int res = new Solution().distMoney(20, 3);
    }
    private static class Solution {
        public int distMoney(int money, int children) {
            if(money < children) return -1; //钱不够
            int num = children * 8 - money; //先为每个人分配8块，计算差值
            if(num == 4) return children - 2; //如果最后一个孩子分得了4元，说明该孩子和上一个孩子都不能分8元
            if(num < 0) return children - 1; //如果最后一个孩子分得了大于8元
            return (money - children) / 7;
        }
    }
}
