package program;

import java.math.BigInteger;
import java.util.ArrayList;

public class _1417 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String ees = solution.reformat("a12bcd");
        System.out.println(ees);
    }
    public static class Solution {
        public String reformat(String s) {
            if(s.length() == 1) return s;
            char[] res = new char[s.length()]; //答案数组
            ArrayList<Character> chars = new ArrayList<>(); //存所有的字母
            ArrayList<Character> nums = new ArrayList<>(); //存所有的数字
            for (char c : s.toCharArray()) {
                if(c<='9' && c>='0') nums.add(c); //存数字
                else chars.add(c); //存字母
            }
            if((chars.isEmpty() || nums.isEmpty()) || (Math.abs(chars.size()-nums.size())>1)) return ""; //字母和数字有一个为空，或者两个数组之间的长度相差大于1，那就无法重新格式化
            int indexA = 0, indexB = 0, resIndex = 0; //字母数组的索引，数字数组的索引，答案数组的索引
            while(resIndex < s.length()){
                res[resIndex++] = chars.size() > nums.size() ? chars.get(indexA++) : nums.get(indexB++); //决定答案数组先存字母还是数组，根据字母和数字的个数决定
                if(resIndex == s.length()) break; //如果答案数组刚好填满了就不需要再存下一个了
                //先根据字母和数字的个数来决定存哪个，然后看该数组索引是否到头了，如果到头了就换另一个数组(避免越界)
                res[resIndex++] = chars.size() > nums.size() ? indexB<nums.size()?nums.get(indexB++):chars.get(indexA++) : indexA<chars.size()?chars.get(indexA++):nums.get(indexB++);
            }
            return String.valueOf(res);
        }
    }
}
