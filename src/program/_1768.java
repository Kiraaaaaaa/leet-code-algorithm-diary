package program;

public class _1768 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.mergeAlternately_1("ab", "pqrs");
        System.out.println(s);
    }
    public static class Solution{
        //方法1：使用stringbuffer添加字符
        public String mergeAlternately(String word1, String word2) {
            StringBuffer res = new StringBuffer();
            //根据较长字符串的长度进行循环
            for (int i = 0; i < (word1.length() >= word2.length() ? word1.length() : word2.length()); i++) {
                //如果当前指针在两个字符串长度之内，则将两个字符串的字符添加到结果字符串中
                if(i < word1.length() && i < word2.length()){
                    res.append(word1.charAt(i));
                    res.append(word2.charAt(i));
                }
                //如果当前指针在较小字符串长度之内，则将较小字符串的字符添加到结果字符串中
                if(i < word1.length() && i >= word2.length()){
                    res.append(word1.charAt(i));
                }
                if(i < word2.length() && i >= word1.length()){
                    res.append(word2.charAt(i));
                }
            }
            return res.toString();
        }

        //方法1的优化，减少了指针在超过较小字符串长度后的判断
        public String mergeAlternately_1(String word1, String word2) {
            StringBuffer res = new StringBuffer();
            int minLen = Math.min(word1.length(), word2.length());
            //根据较短字符串的长度进行循环，添加长度相同的部分
            for (int i = 0; i < minLen; i++) {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }
            //添加两者剩余部分
            res.append(word1.substring(minLen));
            res.append(word2.substring(minLen));
            return res.toString();
        }
    }
}
