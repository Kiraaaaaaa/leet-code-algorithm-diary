package program;

import java.util.ArrayDeque;

public class _2645 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addMinimum_3("aaaaba"));
    }
    public static class Solution {
        //方法1.逐个模拟每种情况，待优化
        public int addMinimum(String word) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int count = 0;
            if(word.length() == 1) return 2;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //判断第一位，第一位字符如果是a肯定跳过，因为它前面不需要补全，否则需要补全
                if(i == 0){
                    if(c == 'b'){
                        count++;
                    }
                    if(c == 'c'){
                        count+=2;
                    }
                    stack.push(c);
                    continue;
                }
                //判断最后一位，除了此字符是c以外，都肯定是不完整的，需要补全
                if(i == word.length()-1){
                    if(c == 'a'){
                        count+=2;
                    }
                    if(c == 'b'){
                        count+=1;
                    }
                }
                //如果该字符是a，它的上一位所有情况
                if(c == 'a'){
                    if(stack.peek() == 'b'){
                        stack.push('c');
                        count++;
                    }else if(stack.peek() == 'a'){
                        stack.push('b');
                        stack.push('c');
                        count += 2;
                    }
                    stack.push(c);
                }
                //如果该字符是b，它的上一位所有情况
                if(c == 'b'){
                    if(stack.peek() == 'c'){
                        stack.push('a');
                        count++;
                    }else if(stack.peek() == 'b'){
                        stack.push('c');
                        stack.push('a');
                        count += 2;
                    }
                    stack.push(c);
                }
                //如果该字符是c，它的上一位所有情况
                if(c == 'c'){
                    if(stack.peek() == 'a'){
                        stack.push('b');
                        count++;
                    }else if(stack.peek() == 'c'){
                        stack.push('a');
                        stack.push('b');
                        count += 2;
                    }
                    stack.push(c);
                }
            }
            return count;
        }
        //方法2.计算单词数量-word字母个数=添加字母个数
        public int addMinimum_1(String word) {
            int count = 1; //单词数量
            char[] s = word.toCharArray();
            for (int i = 0; i < s.length-1; i++) {
                if(s[i] >= s[i+1]) count++; //如果当前字符大于等于下一个字符，则说明是两个单词
            }
            return count*3-word.length();
        }
        //方法3.计算字符之间的差值来统计需要添加的字母数量
        public int addMinimum_2(String word) {
            int count = 0; //需要添加的字母数量
            char[] s = word.toCharArray();
            for (int i = 1; i < s.length; i++) {
                count += (s[i] - s[i - 1] + 2) % 3; //根据公式计算需要添加的字母数量，这里需要添加字母数量=(当前字符-上一个字符+2)与3的余数
            }
            //假如word是bca，那么以上计算的是b到a之间需要添加的字母数量，还需要加上b之前以及a之后需要添加的字母数量
            return count + s[0]-'a' + 'c'-s[s.length-1];
        }
        //方法4.投机取巧，使用API模拟每种情况经过补充后的长度，最后模拟完的长度-原始长度
        public int addMinimum_3(String word) {
            int len = word.length(); //记录原始字母个数
            word = word
                    .replace("abc", "   ")
                    .replace("ab", "   ")
                    .replace("ac", "   ")
                    .replace("bc", "   ")
                    .replace("a", "   ")
                    .replace("b", "   ")
                    .replace("c", "   ");
            return word.length() - len;
        }
    }
}
