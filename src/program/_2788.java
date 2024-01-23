package program;

import java.util.ArrayList;
import java.util.List;

public class _2788 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> list = new ArrayList<>();
        // list.add("one.two.three");
        // list.add("four.five");
        // list.add("six");
        list.add("$easy$");
        list.add("$problem$");
        List<String> strings = solution.splitWordsBySeparator(list, '$');
        System.out.println(strings);
    }
    public static class Solution {
        //方法1.在原数组上修改
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            for (int i = 0; i < words.size(); i++) {
                String s = words.get(i); //获取改位字符串
                String[] split = s.split("\\"+separator); //由于分隔符可能是'.'，而.是一个特殊字符，代表所有字符，所以如果要加一个反斜杠表示这个字符本身
                ArrayList<String> strings = new ArrayList<>(); //存放当前字符串分割后的新字符串数组
                for (String newString : split) {
                    if(newString.length()>0) strings.add(newString);
                }
                words.remove(i); //移除当前字符串
                words.addAll(i, strings); //向当前字符串的位置插入新字符串数组
                i += strings.size()-1; //由于数组长度变化，所以需要重新计算当前字符串的位置
            }
            return words;
        }
    }
}
