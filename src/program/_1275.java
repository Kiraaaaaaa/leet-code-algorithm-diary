package program;

import java.util.ArrayDeque;

public class _1275 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}});
        System.out.println(s);
    }
    public static class Solution{
        public String tictactoe(int[][] moves) {
            //0-2行，3-5列，6正对角线，7副对角线
            int[] count = new int[8];
            for(int i=moves.length-1; i>=0; i-=2){
                //该坐标对行的影响
                count[moves[i][0]]++;
                //该坐标对列的影响
                count[moves[i][1]+3]++;
                //该坐标对正对角线的影响
                if(moves[i][0] == moves[i][1]){
                    count[6]++;
                }
                //该坐标对副对角线的影响
                if(moves[i][0] + moves[i][1] == 2){
                    count[7]++;
                }
                //只要当前行或列或对角线有3个，则当前玩家胜利，moves数组长度为偶数则为A，为奇数则为B
                if(count[moves[i][0]] == 3 || count[moves[i][1]+3] == 3 || count[6] == 3 || count[7] == 3){
                    return moves.length%2==0?"B":"A";
                }
            }
            //如果moves数组长度为9，则平局，否则未结束
            return moves.length == 9 ? "Draw" : "Pending";
        }
    }
}
