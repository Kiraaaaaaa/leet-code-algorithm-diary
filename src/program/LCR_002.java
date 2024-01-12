package program;

public class LCR_002 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addBinary_1("101111", "10");
        System.out.println(s);
        System.out.println(Integer.bitCount(3));
    }
    public static class Solution {
        //方法1.写的比较复杂，不推荐看
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
        //方法2，官方解法
        public String addBinary_1(String a, String b) {
            int len = Math.max(a.length(), b.length());
            int carry = 0; //carry代表进位，有0、1、2三种可能
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < len; i++) {
                //同时计算a和b的最后一位相加结果，如果其中一个字符串长度较短，剩余部分将会以0作替代
                carry += i<a.length()?(a.charAt(a.length()-i-1)-'0'):0;
                carry += i<b.length()?(b.charAt(b.length()-i-1)-'0'):0;
                sb.append(carry%2); //将结果转换为字符串
                carry /= 2; //0和1会被转换成0，代表没有进位，而2会被转换为1代表进了一位，将纳入下一次计算
            }
            if(carry == 1) sb.append("1"); //如果最后一位进位，则追加1
            sb.reverse();
            return sb.toString();
        }
    }
}
