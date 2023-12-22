package program;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class _67 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addBinary("101111", "10");
        System.out.println(s);
    }
    public static class Solution {
        public String addBinary(String a, String b) {
            int len = a.length() < b.length() ? a.length() : b.length();
            boolean flag = false;
            int a_cur = a.length()-1;
            int b_cur = b.length()-1;
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < len; i++) {
                //如果都为1
                if(a.charAt(a_cur) == '1' && b.charAt(b_cur) == '1'){
                    sb.append(flag ? '1' : '0');
                    flag = true;
                }
                //如果其中一个为1
                else if(a.charAt(a_cur) == '1' || b.charAt(b_cur) == '1'){
                    if(flag){
                        sb.append('0');
                        flag = true;
                    }else{
                        sb.append('1');
                        flag = false;
                    }
                }
                //都为0
                else {
                    sb.append(flag ? '1' : '0');
                    flag = false;
                }
                a_cur--;
                b_cur--;
            }
            //如果长度不相等，开始计算较长的字符串剩余部分
            if(a.length() != b.length()){
                //较长字符串与较短字符串的分界线
                int cur = a_cur != -1 ? a_cur : b_cur;
                //如果已完成判断的部分最后还要进一位则开始继续倒着判断剩余部分是否继续进一位
                if(flag){
                    if(a.length() < b.length()){
                        while (cur >= 0 && flag) {
                            if(b.charAt(cur) == '1'){
                                sb.append('0');
                                cur--;
                            }else{
                                sb.append('1');
                                flag = false;
                            }
                        }
                        StringBuffer reverse = new StringBuffer(b.substring(0, flag?cur+1:cur)).reverse();
                        sb.append(reverse);
                        if(flag) sb.append("1");
                    }else{
                        while (cur >= 0 && flag) {
                            if(a.charAt(cur) == '1'){
                                sb.append('0');
                                cur--;
                            }else{
                                sb.append('1');
                                flag = false;
                            }
                        }
                        StringBuffer reverse = new StringBuffer(a.substring(0, flag?cur+1:cur)).reverse();
                        sb.append(reverse);
                        if(flag) sb.append("1");
                    }
                }else{
                    //否则直接将剩余字符串部分拼接到已经完成计算的部分
                    if(a.length() < b.length()){
                        StringBuffer reverse = new StringBuffer(b.substring(0, cur+1)).reverse();
                        sb.append(reverse);
                    }else{
                        StringBuffer reverse = new StringBuffer(a.substring(0, cur+1)).reverse();
                        sb.append(reverse);
                    }
                }
            }else if(flag){
                //如果长度相等但是要进一位，则追加一位1
                sb.append("1");
            }
            return sb.reverse().toString();
        }
    }
}
