package program;

public class _392 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isSubsequence("abc", "ahbgdc");
        System.out.println(res);
    }
    public static class Solution{
        public boolean isSubsequence(String s, String t) {
            //特殊情况1.如果s为空，则t也为空
            if(s.length() == 0) return true;
            int s_index = 0; //s指针
            for (int i = 0; i < t.length(); i++) {
                //如果按照顺序匹配字符一样，则s指针右移，准备匹配下一个字符
                if(s.charAt(s_index) == t.charAt(i)) s_index++;
                //如果s指针到达末尾，并且i不为0(去除字符串只有一位的特殊情况)，则说明s里的字符匹配完了
                if(s_index == s.length() && i!=0) return true;
            }
            return false;
        }
    }
}
