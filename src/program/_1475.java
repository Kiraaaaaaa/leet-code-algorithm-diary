package program;

import java.util.ArrayList;

public class _1475 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.finalPrices(new int[]{10,1,1,6});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static class Solution {
        public int[] finalPrices(int[] prices) {
            for (int i = 0; i < prices.length; i++) {
                for(int j = i + 1; j < prices.length; j++){
                    if(prices[j] <= prices[i]){
                        prices[i] -= prices[j]; break;
                    }
                }
            }
            return prices;
        }
    }
}
