package program;

import java.util.HashMap;

public class _290 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.wordPattern("abba", "dog cat cat dog");
        System.out.println(res);
    }
    public static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] arr = s.split(" ");
            //1.先判断各自长度，如果字符长度和单词个数不匹配直接返回false
            if(arr.length != pattern.length()) return false;
            //2.前者作为key，后者作为value
            HashMap<Character, String> map = new HashMap<>();
            //3.根据字符长度对每个对应关系逐一判断
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                //3.1.如果该字符没有作为key，说明是一个新的对应关系，将其存入到map中
                if(!map.containsKey(c)){
                    //3.2.如果map中已经有该字符对应的单词了，说明对应关系冲突了，题目要求不同的对应关系不能存相同的单词，直接返回false
                    if(map.containsValue(arr[i])) return false;
                    //3.3.如一切正常将该字符和单词的对应关系存到map中
                    map.put(c, arr[i]);
                }else if(!map.get(c).equals(arr[i])){
                    //3.4.如果map中已经有该字符的记录了，则直接比较记录中的单词是否和当前的单词是否一致，不一致则返回false
                    return false;
                }
            }
            //一切正常的情况
            return true;
        }
    }
}
