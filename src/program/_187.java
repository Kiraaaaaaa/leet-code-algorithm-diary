package program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _187 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(res);
    }
    public static class Solution {

        //方法1.滑动窗口
        public List<String> findRepeatedDnaSequences(String s) {
            int l = 0, r = 9; //窗口固定值10
            int n = s.length();
            HashSet<String> set = new HashSet<>(); //存出现过的子字符串
            HashSet<String> ans = new HashSet<>(); //存出现过两次及以上的字符串
            while(r < n){ //滑到最右边
                String sub = s.substring(l, l+10); //取出当前子字符串
                if(set.contains(sub)) ans.add(sub); //如果该字符串之前一次出现过加入到结果集中
                set.add(sub); //存放该字符串
                l++; //左指针移动
                r++; //右指针移动
            }
            return new ArrayList<>(ans);
        }
    }
}
