package program;

public class string_to_url_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }
    public static class Solution {
        //应题目要求使用字符数组来做
        public String replaceSpaces(String S, int length) {
            char[] chars = new char[S.length()]; //存放答案
            int cur = 0; //chars数组的指针
            int count = 0; //计算已经加了多少个字符了，"%20"算一个字符
            for (int i = 0; i < S.length(); i++) {
                //如果已经加了count个字符，则返回chars数组，注意原字符串末尾的空格要舍弃，所以只需要0~cur-1的字符
                if(count == length) return new String(chars, 0, cur);
                //如果当前字符不是空格，则直接放入chars数组
                if(S.charAt(i)!=' ') chars[cur++] = S.charAt(i);
                //否则，将"%20"放入chars数组
                else for(int j=0; j<3; j++){
                    if(j==0) chars[cur] = '%';
                    else if(j==1) chars[cur] = '2';
                    else chars[cur] = '0';
                    ++cur;
                }
                //只要加了1个字符，就加1个count
                ++count;
            }
            return S; //如果没有空格，则返回原字符串
        }
    }
}
