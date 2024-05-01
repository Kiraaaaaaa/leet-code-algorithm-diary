package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _763 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(res);
    }
    public static class Solution {
        //方法1.map+双指针
        //思路：map记录下每个字母最后出现的位置，left指针记录下区间开始的地方，right记录下区间最右边的位置
        //遍历字符串，如果当前字母最后出现的位置大于right，则更新right为当前字母最后出现的位置
        //如果当前字母最后出现的位置小于right，则说明当前字母在区间内，则继续遍历
        //如果当前字母最后出现的位置等于right，则说明当前字母在区间内。也说明这个区间所有字母都不会超过该区间了
        //将区间长度加入到结果中，并更新left为right，开始下一个区间
        //ps.当时一遍过，时间击败98%，我膨胀了
        public List<Integer> partitionLabels(String s) {
            int n = s.length();
            ArrayList<Integer> res = new ArrayList<>();
            int[] map = new int[26];//存储字母最后出现坐标
            for (int i = 0; i < n; i++) {
                map[s.charAt(i) - 'a'] = i;
            }
            int left = 0, right = 0; //区间左右边界
            while(right < n){ //遍历整个字符串
                char p = s.charAt(left); //区间最左边的字母
                int last = map[p - 'a']; //该字母最后出现的位置
                while(right <= last){ //遍历区间内所有字母，如果结束循环说明是一个新区间
                    char q = s.charAt(right); //区间内的一个字母
                    int now_last = map[q - 'a']; //该字母最后出现的位置
                    if(now_last > last) last = now_last; //如果该字母最后出现的位置大于我们当前拟定的最大区间right，则更新右边界为该字母最后出现的位置
                    right++; //继续遍历下一个字母
                }
                res.add(right - left); //区间长度加入到结果中
                left = right; //更新新区间起始位置
            }
            return res;
        }
    }
}
