package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _524 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        String res = solution.findLongestWord("abpcplea", list);
        System.out.println(res);
    }
    public static class Solution {
        // 方法1.双指针
        public String findLongestWord(String s, List<String> dictionary) {
            Collections.sort(dictionary, (a,b)->{
                if(a.length() != b.length()) return b.length() - a.length();
                return a.compareTo(b);
            });
            for (String ss : dictionary){
                int startA = 0, startB = 0; //双指针，startA是s的指针，startB是ss的指针
                while(startA < s.length() && startB < ss.length()){
                    if(s.charAt(startA) == ss.charAt(startB)) ++startB; //如果ss的字符和s的字符相等，startB右移
                    ++startA; //每次s的指针都需要右移
                }
                if(startB == ss.length()) return ss; //如果startB已经遍历完ss，说明s子串匹配ss，返回ss
            }
            return "";
        }
    }
}
