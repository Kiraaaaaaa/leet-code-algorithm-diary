package program;

import java.util.Arrays;

public class _3114 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.findLatestTime("1?:?4");
        System.out.println(res);
    }
    static class Solution {
        public String findLatestTime(String s) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(i == 0 && chars[i] == '?'){ //第一位
                    if(chars[i+1] == '1' || chars[i+1] == '0' || chars[i+1] == '?') chars[i] = '1'; //如果第二位是1或0或问号，则第一位为1
                    else chars[i] = '0'; //如果第二位不是1或0或问号，则第一位为0
                }
                if(i == 1 && chars[i] == '?'){ //第二位
                    if(chars[i-1] == '0') chars[i] = '9'; //如果前一位是0，则第二位为9
                    else chars[i] = '1'; //如果前一位不是0，则第二位为1
                }
                if(i == 3 && chars[i] == '?') chars[i] = '5'; //第三位
                if(i == 4 && chars[i] == '?') chars[i] = '9'; //第四位
            }
            return String.valueOf(chars);
        }
    }
}
