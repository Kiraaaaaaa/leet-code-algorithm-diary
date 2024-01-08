package program;

public class one_away_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oneEditAway("pale", "ple"));
    }
    public static class Solution{
        int aLen, bLen;
        String a, b;
        public boolean oneEditAway(String first, String second) {
            aLen = first.length();
            bLen = second.length();
            a = first;
            b = second;
            //如果长度相差大于1，则肯定不行
            if(aLen + 1 < bLen || bLen + 1 < aLen) return false;
            if(aLen == bLen) return helper(0); //长度相等的情况
            else if (aLen > bLen) return helper(1); //a更长的情况
            else return helper(2); //b更长的情况
        }
        private boolean helper(int flag) {
            //以较短的字符串作为循环次数
            for (int i = 0; i < Math.min(aLen, bLen); i++) {
                //如果出现不相等的字符
                if(a.charAt(i) != b.charAt(i)){
                    //如果长度相同，则两者指针都右移一位，比较剩余字符串是否相等
                    if(flag == 0) return a.substring(i+1).equals(b.substring(i+1));
                    //如果a更长，则a指针右移一位，b指针不动，比较剩余字符串是否相等
                    else if(flag == 1) return a.substring(i+1).equals(b.substring(i));
                    //如果b更长，则a指针不动，b指针右移一位，比较剩余字符串是否相等
                    else return a.substring(i).equals(b.substring(i+1));
                }
            }
            return true;
        }
    }
}
