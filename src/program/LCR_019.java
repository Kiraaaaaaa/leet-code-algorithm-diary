package program;

public class LCR_019 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abcxba"));
    }
    public static class Solution{
        public boolean validPalindrome(String s) {
            boolean first_check = isPalindrome_1(s, -1);
            if(!first_check){
                for (int i = 0; i < s.length(); i++) {
                    boolean check = isPalindrome_1(s, i);//如果初步验证不是回文串，则开始尝试删除每一位，看是否能通过验证
                    if(check) return check;
                }
            }
            return first_check;
        }
        //方法2.使用双指针，比较字符串的首尾字符，不使用别的API，比较ASCII码
        public boolean isPalindrome_1(String s, int index) {
            int left = 0, right = s.length()-1;
            while(left < right){
                char l = s.charAt(left);
                char r = s.charAt(right);
                while(left < right && l < '0' || (l > '9' && l < 'A') || l < 'a' && l > 'Z' || l > 'z' || left == index){
                    l = s.charAt(++left); //如果左边的字符不是字母或者数字则左指针右移直到匹配到字母或者数字
                }
                while(left < right && r < '0' || (r > '9' && r < 'A') || r < 'a' && r > 'Z' || r > 'z' || right == index){
                    r = s.charAt(--right); //如果右边的字符不是字母或者数字则右指针左移直到匹配到字母或者数字
                }
                if(l<='9' && r>='A' || r<='9' && l>='A') return false; //如果一个字符为字母，另一个字符为数字，则不是回文串
                if(l != r && Math.abs(l - r) != 32) return false; //如果两字符不相同且两字符不是对应的大小写，则不是回文串
                ++left;
                --right;
            }
            return true;
        }
    }
}
