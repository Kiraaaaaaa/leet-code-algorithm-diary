package program;

import java.util.ArrayList;

public class _500 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] res = solution.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        for (String re : res) {
            System.out.println(re);
        }

    }
    public static class Solution {
        public String[] findWords(String[] words) {
            String[] lines = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            ArrayList<String> res = new ArrayList<>(); //存储符合要求的字符串
            for (int i = 0; i < words.length; i++) {
                boolean inLine = true; //该字符串是否在一行中
                for (String string : lines) { //遍历这三行
                    if(string.contains(""+Character.toLowerCase(words[i].charAt(0)))){ //取出该字符串的第一个字符找到待匹配的行
                        for(int j = 0; j < words[i].length(); j++){ //遍历该字符串的每个字符
                            if(!string.contains(Character.toLowerCase(words[i].charAt(j))+"")){ //如果该字符不在该行中
                                inLine = false; //则表示该字符串不在任何一行中
                                break; //不用再判断该字符串的后续字符了
                            }
                        }
                    }
                    if(!inLine) break; //如果该字符串部分字符不在该行中，就跳出循环，避免去其他行继续判断
                }
                if(inLine) res.add(words[i]); //如果该字符串在某一行中，就添加到结果中
            }
            return res.toArray(new String[0]);
        }
    }
}
