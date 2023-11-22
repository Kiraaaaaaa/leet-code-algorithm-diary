package 刷题;

public class _125 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean i = solution.isPalindrome("0P");
        System.out.println(i);
    }
    public static class Solution{
        public boolean isPalindrome(String s) {
            int start = 0, end = s.length()-1;
            while (start<=end){
                //先转为字符
                char pre = s.charAt(start);
                char last = s.charAt(end);
                //如果左指针的字符不属于数字或者字母就继续右移
                if(!Character.isLetterOrDigit(pre)){
                    start++;
                }else if(!Character.isLetterOrDigit(last)){
                    //如果右指针的字符不属于数字或者字母就继续左移
                    end--;
                }else if(Character.toLowerCase(pre) != Character.toLowerCase(last)){
                    //排除以上两种情况的字符通过转为小写开始比较，不一样则直接返回失败
                    return false;
                }else{
                    //字符匹配，指针各自移动一次
                    start++;
                    end--;
                }
            }
            //配对完毕，是回文字符串
            return true;
        }
    }
}
