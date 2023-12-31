package program;

import java.util.HashMap;

public class _1071 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.gcdOfStrings("ABABAB", "ABAB");
        System.out.println(s);
    }

    public static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            //正在尝试的最大公因子
            StringBuffer x = new StringBuffer();
            //将最大公因子填充到str1长度或者str2长度的测试字符串(用来测试是否能匹配两个字符串)
            StringBuffer temp;
            //最终最大公因子
            String res = new String();
            for (int i = 0; i < str2.length(); i++) {
                //从左到右将str2的一个数添加到x
                x.append(str2.charAt(i));
                //同时测试字符串初始化为x(务必注意是深拷贝)
                temp = new StringBuffer(x);
                //如果str2长度不能被x的长度整除，说明连str2都不能满足，他们的长度必须是倍数关系
                if(str2.length()%x.length()!=0) continue;

                //得到str2需要多少个x
                int copyNum_s2 = str2.length()/x.length();
                //1.将temp填充到str2的长度，查看是否匹配str2
                while(--copyNum_s2 > 0){
                    temp.append(x);
                    //如果正在填充过程中的字符串都不在str2中，则没必要继续添加了
                    if(!str2.contains(temp)) continue;
                }
                //如果不匹配str2，继续添加下一个数到x
                if(!temp.toString().equals(str2)) continue;


                //2.如果满足str2，查看是否匹配str1
                int copyNum_s1 = str1.length()/x.length();
                //重置temp为x，开始校验str2
                temp = new StringBuffer(x);
                //1.将temp填充到str1的长度，查看是否匹配str1
                while (--copyNum_s1 > 0) {
                    temp.append(x);
                    //如果正在填充过程中的字符串都不在str1中，则没必要继续添加了
                    if(!str1.contains(temp)) continue;
                }

                //如果也不满足str1，x继续添加str2的字符。
                if(!temp.toString().equals(str1)){
                    continue;
                }else{
                    //如果满足，则设置最终最大公因子为当前尝试的x
                    res = x.toString();
                }
            }
            return res;
        }
    }
}
