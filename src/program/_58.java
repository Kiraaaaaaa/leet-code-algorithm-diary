package program;

public class _58 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int len = solution.lengthOfLastWord_2("   fly me   to   the moon  ");
        System.out.println(len);
    }
    public static class Solution{
        //方法1：不要脸API版
        public int lengthOfLastWord(String s) {
            String[] string = s.split(" ");
            return string[string.length-1].length();
        }
        //方法2：从右向左遍历
        public int lengthOfLastWord_1(String s) {
            boolean find = false; //是否找到第一个非空字符
            int len = 0;
            for(int i=s.length()-1; i>=0; i--){
                //如果找到第一个非空字符，则设置为开始计数状态
                if(s.charAt(i) != ' ') find = true;
                //如果为计数状态，且当前字符为非空字符，则计数
                if(find && s.charAt(i) != ' ') ++len;
                //如果为计数状态，且当前字符为空字符，则结束计数
                if(find && s.charAt(i) == ' ') break;
            }
            return len;
        }
        //方法3：方法2的改进，代码更简洁
        public int lengthOfLastWord_2(String s) {
            int len = 0;
            for(int i=s.length()-1; i>=0; i--){
                char c = s.charAt(i);
                if(c != ' ') ++len;
                if(len!=0 && c==' ') break;
            }
            return len;
        }
    }
}
