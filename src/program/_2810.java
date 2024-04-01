package program;

import java.util.LinkedList;

public class _2810 {
    public static void main(String[] args) {
        Solution so = new Solution();
            String res = so.finalString("siiuii");
        System.out.println(res);
    }
    static class Solution {
        public String finalString(String s) {
            StringBuffer sb = new StringBuffer();
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'i'){
                    cnt++;
                    if(i == s.length() - 1 && cnt % 2 != 0) sb.reverse();
                    continue;
                }
                if(cnt % 2 != 0){
                    sb.reverse();
                }
                cnt = 0;
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
