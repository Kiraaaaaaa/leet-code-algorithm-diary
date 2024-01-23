package program;

public class LCP_01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.game(new int[]{2,2,1}, new int[]{3,2,1});
        System.out.println(res);
    }
    public static class Solution {
        int len = 0;
        public int game(int[] guess, int[] answer) {
            if(len == 2) return guess[len] == answer[len] ? 1 : 0;
            return (guess[len]==answer[len++]?1:0) + game(guess, answer);
        }
    }
}
