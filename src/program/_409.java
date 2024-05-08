package program;

import java.util.ArrayList;
import java.util.List;

public class _409 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestPalindrome("bb");
        System.out.println(res);
    }
    public static class Solution {

        //方法1.使用字母表存储出现次数(或者哈希表)
        //遇到已经存储过的字母，如果加上当前这个后个数是偶数，则答案+2，并且总数total-2
        //如果最后总数不为0，则说明有奇数个字母，答案+1
        public int longestPalindrome(String s) {
            int[] count = new int[58]; // 字母表以及对应出现次数，注意是包含大小写的，所以是26*2+6个特殊字符
            int res = 0, n = s.length();
            int total = n; //记录字母总数，遇到两个一对的，则-2，最后总数为0说明没有留奇数字母
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i); // 当前字符
                int index = c - 'A'; // 当前字符在字母表中的位置
                if(count[index] > 0){
                    if(count[index]%2 != 0){ //如果已经存了奇数个了
                        res += 2; //加上当前这个就又凑成两个了，所以答案+2
                        total -= 2; //记得只出现一次的字母总数-2
                    }
                }
                count[index]++; //当前字符出现次数+1
            }
            return res + (total > 0 ? 1 : 0);
        }
    }
}
