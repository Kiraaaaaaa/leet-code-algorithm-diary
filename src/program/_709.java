package program;

public class _709 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.toLowerCase_2("Hello");
        System.out.println(s);
    }
    public static class Solution{
        //方法1：不要脸API版1.0
        public String toLowerCase(String s) {
            return s.toLowerCase();
        }
        //方法2：不要脸API版2.0(脱裤子放屁)
        public String toLowerCase_1(String s) {
            char[] chars = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                c = Character.toLowerCase(c); //将每一位字符转换为小写
                chars[i] = c;
            }
            return String.valueOf(chars);
        }
        //方法3.ASCII码版
        public String toLowerCase_2(String s) {
            char[] chars = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if((int)c <= 'Z' && (int)c >= 'A'){
                    c = (char)(c+32); //如果是大写字母，ASCII码则在'A'到'Z'之间，则将其转换为小写，将其ASCII码加32即可，A的ASCII码为65，a的ASCII码为97
                }
                chars[i] = c;
            }
            return String.valueOf(chars);
        }
    }
}
