package program;

public class _13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.romanToInt("MCMXCIV");
        System.out.println(res);
    }

    /**
     * 思路：在遍历当前字符时，判断下一位字符是否比自己大，如果是，则减去自己，否则加上自己。
     */
    public static class Solution{
        public int romanToInt(String s) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(i == s.length()-1) return ans+=getNum(c);
                char next = s.charAt(i + 1);
                int num1 = getNum(c), num2 = getNum(next);
                ans += num1 < num2 ? -num1 : num1;
            }
            return ans;
        }
        private int getNum(char c) {
            switch (c){
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
    }
}
