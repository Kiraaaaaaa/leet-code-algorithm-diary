package program;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _1324 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.printVertically("TO BE OR NOT TO BE");
        System.out.println(res);
    }
    public static class Solution{
        public List<String> printVertically(String s) {
            String[] strings = s.split(" "); // 分割字符串为字符串数组
            int size = 0, len = strings.length; // 分割后最长的字符串的长度，以及字符串的个数
            for (int i = 0; i < strings.length; i++) {
                int n = strings[i].length();
                if(n > size){
                    size = n; // 最长的字符串的长度
                }
            }
            ArrayList<StringBuffer> ans = new ArrayList<>(); // 结果集合
            for (int i = 0; i < size; i++) {
                StringBuffer sb = new StringBuffer();
                ans.add(sb); // 初始化出保存每个字符串的缓存区，并添加到集合中
                for (int j = 0; j < len; j++) {
                    if(i < strings[j].length()){
                        ans.get(i).append(strings[j].charAt(i));
                    }else{
                        ans.get(i).append(" ");
                    }
                }
            }
            List<String> res = ans.stream().map(i -> i.toString().stripTrailing()).collect(Collectors.toList());
            return res;
        }
    }
}
