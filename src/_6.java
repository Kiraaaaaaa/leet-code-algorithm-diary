import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class _6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.convert("AB", 2);
        System.out.println(s);
    }

    public static class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1) return s;
            ArrayList<StringBuffer> tempList = new ArrayList<>(numRows); //记录每一行的字符串
            int line = 0, flag = -1; //行数计数器，与行数变化规则是正序还是倒序
            for(int i = 0; i < s.length(); i++) {
                if(i < numRows) tempList.add(new StringBuffer()); //初始化每一行的StringBuffer
                tempList.get(line).append(s.charAt(i)); //向指定行添加字符
                if(line == numRows-1 || line == 0) flag = -flag; //到最后一行设置为false，行数开始倒序，正序同理
                line += flag; //行数发生变化
            }
            return String.join("", tempList);
        }
    }
}
