package program;

import java.util.ArrayList;

public class _860 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.lemonadeChange(new int[]{5, 5, 5, 10, 20});
        System.out.println(res);
    }
    public static class Solution{
        public boolean lemonadeChange(int[] bills) {
            int[] save = new int[2]; //0-5 1-10 手上的钱数量
            for (int i = 0; i < bills.length; i++) {
                if(bills[i] == 5) ++save[0]; //5元数量+1，不需要换钱
                if(bills[i] == 10){ //如果是10元
                    if(save[0] >= 1){ //如果5元数量大于1
                        --save[0]; //5元数量-1
                        ++save[1]; //10元数量+1
                    } else return false; //否则换不过来
                }
                if(bills[i] == 20){ //如果是20元
                    //先考虑是否有一张10和5，先把10用了
                    if(save[1]>=1 && save[0]>=1){ //如果各自至少都有一张
                        --save[0]; //用一张5元
                        --save[1]; //用一张10元
                    }else if(save[0] >= 3){ //没有10元的话，那如果5元数量有三张及以上，也可以直接消耗三张5元
                        save[0] -= 3;
                    }else return false; //否则换不过来
                }
            }
            return true;
        }
    }
}
