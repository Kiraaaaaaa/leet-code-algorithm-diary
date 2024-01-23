package program;

public class _2264 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.largestGoodInteger("2300019");
        System.out.println(res);
    }
    public static class Solution {
        //方法1.滑动窗口
        public String largestGoodInteger(String num) {
            int max = -1;
            String res = "";
            for (int i = 0; i < num.length()-2; i++) {
                boolean flag = true;
                for(int j = i; j < i+2; j++){
                    if(num.charAt(j) != num.charAt(j+1)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    String substring = num.substring(i, i + 3);
                    int n = Integer.parseInt(substring);
                    if(n > max){
                        res = substring;
                        max = n;
                    }
                }
            }
            return res;
        }
    }
}
