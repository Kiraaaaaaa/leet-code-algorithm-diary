package program;

public class _100235 {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.maxBottlesDrunk2(10, 3);
        System.out.println(res);
    }
    static class Solution {
        //方法1.纯模拟
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int ans = 0, full = numBottles, empty = 0;
            while(full != 0 || empty >= numExchange){ //只要有满瓶的酒或者空瓶酒还能继续兑换就继续
                if(empty >= numExchange){ //优先换酒
                    empty -= numExchange; //换酒
                    full += 1; //得到一瓶满酒
                    numExchange++; //兑换需要的空酒瓶次数加一
                }else{
                    empty += full; //把所有满瓶酒瓶转换成空瓶
                    ans += full; //喝掉所有满瓶酒
                    full = 0; //满瓶酒清零
                }
            }
            return ans;
        }
        //方法2.更简洁的写法
        public int maxBottlesDrunk2(int numBottles, int numExchange) {
            int count = 0, empty = numBottles;
            while(empty >= numExchange){
                empty = empty - numExchange++ + 1;
                count++;
            }
            return numBottles + count;
        }
    }
}
