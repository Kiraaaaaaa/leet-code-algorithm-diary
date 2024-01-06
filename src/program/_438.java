package program;

import java.util.*;

public class _438 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        List<Integer> lis = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(lis);
    }
    public static class Solution {
        //1.自己写的，超时，排序子字符串来比较是否异构
        public List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> list = new ArrayList<>();
            int start = 0, end = p.length()-1;
            char[] arr = p.toCharArray();
            Arrays.sort(arr); //排序p
            String sort = String.valueOf(arr);//转为string
            while(end < s.length()){
                char c = s.charAt(start);
                //如果当前字符在p中，才需要验证其子串
                if(p.indexOf(c) != -1){
                    StringBuffer sb = new StringBuffer();
                    for(int i=start; i<=end; i++){
                        sb.append(s.charAt(i));
                    }
                    String string = sb.toString();
                    char[] chars = string.toCharArray();
                    Arrays.sort(chars); //排序sb
                    String sorted = String.valueOf(chars);//转为string
                    if(sorted.equals(sort)){
                        list.add(start);
                    }
                }
                start++;
                end++;
            }
            return list;
        }
    }
    //2. 官方题解，滑动窗口，使用频率表来记录当前窗口中字符的出现个数
    public List<Integer> findAnagrams_1(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        ArrayList<Integer> ans = new ArrayList<>();
        //记录当前窗口中字符的出现个数
        int[] sCount = new int[26];
        //记录p中字符的出现个数
        int[] pCount = new int[26];
        //先验证第一个窗口中字符的出现个数
        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i)-'a']; //统计s的当前窗口中的字符出现个数
            ++pCount[p.charAt(i)-'a']; //初始化p中的字符出现个数
        }
        //判断两个统计结果是否相等
        if(Arrays.equals(sCount, pCount)){
            ans.add(0); //如果相等，说明第一个窗口是p的子串，将第一个坐标其加入结果集
        }
        //开始判断移动后的窗口
        for (int i = 0; i < sLen-pLen; i++) {
            --sCount[s.charAt(i)-'a']; //由于窗口右移，窗口最左边的字符个数-1
            ++sCount[s.charAt(i+pLen)-'a']; //由于窗口右移，窗口最右边的字符个数-1
            //再次判断两个统计结果是否相等
            if(Arrays.equals(sCount, pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
