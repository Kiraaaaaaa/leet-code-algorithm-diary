package program;

import java.util.Arrays;

public class _1390 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.sumFourDivisors(new int[]{21,21});
        System.out.println(res);
    }
    public static class Solution {
        public int sumFourDivisors(int[] nums) {
            int res = 0;
            int[] cache = new int[100001];
            Arrays.fill(cache, -1);
            for (int num : nums) {
                if(cache[num] != -1){ // 如果该数已经计算过，直接取缓存
                    res += cache[num];
                    continue;
                }
                int cnt = 0; // 记录该数的因子个数
                int sum = 0; // 记录该数的因子之和
                for (int i = 1; i * i <= num; i++) { // q枚举因子，因子肯定小于等于sqrt(num)
                    if(num % i == 0){ // 如果是因子，因子个数加一
                        cnt++;
                        sum += i;
                        if(i * i != num){ // 枚举第二个因子，只有这两个因子不相同，才能加上这另一个因子
                            cnt++;
                            sum += num / i; // 加上另一个因子
                        }
                    }
                }
                if(cnt == 4){ // 因子个数为4则添加其因子和
                    res += sum;
                }
                //存缓存
                cache[num] = cnt == 4 ? sum : 0;
            }
            return res;
        }
    }
}
