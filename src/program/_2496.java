package program;

public class _2496 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumValue(new String[]{"alic3", "bob", "3", "4", "00000"});
        System.out.println(res);
    }
    public static class Solution {
        public int maximumValue(String[] strs) {
            int max = 0;
            for (String str : strs) {
                boolean isNum = true;
                for (char c : str.toCharArray()) {
                    if(c >= 'a' && c <= 'z'){
                        isNum = false;
                        break;
                    }
                }
                max = Math.max(max, isNum ? Integer.parseInt(str) : str.length());
            }
            return max;
        }
    }
}
