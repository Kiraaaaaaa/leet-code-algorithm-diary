package program;

import java.util.*;
import java.util.stream.Collectors;

public class _2182 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.repeatLimitedString_1("ccacc", 3);
        System.out.println(s);
    }
    public static class Solution {

        //方法1.思路：先倒序排序字符串，然后将大于repeatLimit长度的第一个字符和字典序的下一个字符做交换
        //但是有个bug，即Collections.swap交换后数组还是原来的数组
        public String repeatLimitedString(String s, int repeatLimit) {
            List<Character> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            List<Character> sorted = collect.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            for (int i = 0; i < sorted.size()-repeatLimit; i++) {
                boolean continuous = true;
                for (int j = i; j < i+repeatLimit-1; j++) {
                    if(!sorted.get(i).equals(sorted.get(i+1))) continuous = false;
                }
                if(continuous){
                    Collections.swap(sorted, i+repeatLimit, i+repeatLimit+1);
                }
            }
            return null;
        }
        //方法2.使用数组存下每种字符的出现次数，然后倒序遍历
        public String repeatLimitedString_1(String s, int repeatLimit) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                ++map[c-'a'];
            }
            StringBuilder sb = new StringBuilder();
            int count = 0; // 当前字符出现次数
            for(int cur = 25, pre = 24; cur >= 0 && pre >= 0;){
                if(map[cur] == 0){ //如果没有当前字符则跳过
                    count = 0; //同时已存字符个数计数器归零
                    --cur;
                }else if(count < repeatLimit){ //如果计数器没达到指定的repeatLimit，则表示当前字符正在存放
                    --map[cur]; // 减少当前字符个数
                    sb.append((char)(cur+97)); //存放该字符到新的字符串中
                    ++count; //同时计数器+1
                }else if(pre >= cur || map[pre] == 0){ //如果存放的该字符长度已经大于repeatLimit，并且当前字符前一个字典序的字符不存在，则先跳过
                    --pre; //直到找到下一个字典序存在的字符
                }else{
                    --map[pre];
                    sb.append((char)(pre+97));
                    count = 0;
                }
            }
            return sb.toString();
        }
    }
}
