package program;

public class _205 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        boolean b = solution.isPalindrome(121);
        System.out.println("字符串对比结果：");
        System.out.println(b);
    }
    public static class Solution{
        public boolean isPalindrome(int num) {
            return String.valueOf(num).equals(new StringBuffer(String.valueOf(num)).reverse().toString());
        }
    }
}
