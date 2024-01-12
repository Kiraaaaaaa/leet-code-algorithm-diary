package program;

import java.util.ArrayDeque;
import java.util.Deque;

public class _657 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.judgeCircle("UD");
        System.out.println(res);
    }
    public static class Solution{
        public boolean judgeCircle(String moves) {
            int x=0, y=0;
            for (int i = 0; i < moves.length(); i++) {
                char c = moves.charAt(i);
                switch (c){
                    case 'U': ++y; break;
                    case 'D': --y; break;
                    case 'L': --x; break;
                    default: ++x;
                }
            }
            return x==0 && y==0;
        }
    }
}
