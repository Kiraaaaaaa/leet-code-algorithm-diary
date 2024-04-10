package program;

public class _1702 {
    public static void main(String[] args) {
        Solution so = new Solution();
        String res = so.maximumBinaryString("000110");
        System.out.println(res);
    }
    static class Solution {
        //方法1.找规律构造法，最终字符串只会出现一个0。找出第一个0出现的坐标，和0总出现次数count，在这个坐标之上右移count-1位设置为0，其它都为1
        public String maximumBinaryString(String binary) {
            int first_zero = binary.indexOf('0'), zero_count = 0;
            if(first_zero < 0) return binary;
            char[] s = binary.toCharArray();
            for (int i = 0; i < s.length; i++) {
                if(s[i] == '0') zero_count++;
                s[i] = '1';
            }
            s[first_zero + zero_count - 1] = '0';
            return String.valueOf(s);
        }
    }
}
