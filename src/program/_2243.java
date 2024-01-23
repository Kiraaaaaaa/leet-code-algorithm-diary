package program;

public class _2243 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.digitSum("01234567890", 2);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.递归
        public String digitSum(String s, int k) {
            if(s.length() <= k) return s; //如果长度小于等于k，直接返回s
            int len = s.length();
            int part = (int) Math.ceil((double) len / k); //计算被分割成了几个部分
            StringBuilder newS = new StringBuilder(); //构建新的字符串
            int startIndex = 0; //当前子字符串的起始位置
            for (int i = 0; i < part; i++) { //对于每个分割的部分，分别计算他们的和
                int sum = 0; //当前子字符串的和
                for(int j = startIndex; j < s.length() && j < startIndex+k; j++){
                    sum += s.charAt(j)-'0';
                }
                startIndex = startIndex + k; //更新起始位置
                newS.append(sum);
            }
            return digitSum(newS.toString(), k); //继续递归计算新的字符串
        }
    }
}
