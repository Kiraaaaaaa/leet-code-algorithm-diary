package program;

import java.util.Arrays;

public class _100326 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.compressedString("ab");
        System.out.println(res);
    }
    public static class Solution {

        //方法1.双指针
        public String compressedString(String word) {
            StringBuilder sb = new StringBuilder();
            char[] chars = word.toCharArray();
            int left = 0; // 左指针坐标
            char lc = chars[0]; // 左指针字符
            for (int right = 0; right < chars.length; right++) { //右指针移动
                char rc = chars[right]; // 右指针字符
                if(lc != rc){ // 左指针字符和右指针字符不相等，需要添加该字符到结果中
                    int count9 = (right - left) / 9; // 计算该字符出现次数包含多少个9
                    if(count9 != 0){ // 如果该字符出现9次以上，就记录到字符串中
                        for (int i = 0; i < count9; i++) {
                            sb.append("9"+lc);
                        }
                    }
                    int mod = (right - left) % 9; // 计算该字符剩余出现次数的余数
                    if(mod != 0){  // 如果该字符剩余出现次数不为0，就记录到字符串中
                        sb.append(String.valueOf(mod)+lc);
                    }
                    left = right; // 更新左指针坐标和左指针字符
                    lc = chars[left];
                }
            }
            // 处理最后一个字符，步骤类似
            int count9 = (chars.length - left) / 9;
            if(count9 != 0){
                for (int i = 0; i < count9; i++) {
                    sb.append("9"+lc);
                }
            }
            int mod = (chars.length - left) % 9;
            if(mod != 0){
                sb.append(String.valueOf(mod)+lc);
            }
            return  sb.toString();
        }
    }
}
