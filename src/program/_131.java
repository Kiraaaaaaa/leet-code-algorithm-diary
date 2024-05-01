package program;

import java.util.*;

public class _131 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.partition("aab");
        System.out.println(res);
    }
    public static class Solution {
        int len;
        char[] charArray;
        Deque<String> stack;
        List<List<String>> res;
        //方法1.回溯
        public List<List<String>> partition(String s) {
            len = s.length();
            res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            stack = new ArrayDeque<>(); // 栈，存储分割好的子串
            charArray = s.toCharArray();
            dfs( 0); // 从第0个字符开始
            return res;
        }

        private void dfs(int index) {
            if (index == len) {
                res.add(new ArrayList<>(stack)); // 如果当前遍历的字符串坐标等于字符串的长度，说明分割结束，将栈中的元素加入到结果集
                return;
            }
            for (int i = index; i < len; i++) {
                // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
                if (!checkPalindrome(charArray, index, i)) {
                    continue; // 不是回文子串，直接跳过
                }
                stack.addLast(new String(charArray, index, i + 1 - index)); // 是回文子串，加入到栈中
                dfs(i + 1); // 继续遍历下一个字符
                stack.removeLast(); // 回溯
            }
        }
        private boolean checkPalindrome(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
