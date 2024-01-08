package program;

public class palindrome_permutatio_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("AaBb//a"));
    }
    public static class Solution{
        public boolean canPermutePalindrome(String s) {
            int[] book = new int[128];
            int count = 0; //记录奇数的个数
            for (int i = 0; i < s.length(); i++) {
                ++book[s.charAt(i)]; //先存储每个字符出现的次数，由于是大小写，特殊字符都存在，所以直接用字母的ASCII码来做索引
            }
            for (int i = 0; i < book.length; i++) {
                if(book[i]%2 != 0) count++; //统计奇数的个数，最多只能有一个奇数
                if(count > 1) return false;
            }
            return count <= 1;
        }
    }
}
