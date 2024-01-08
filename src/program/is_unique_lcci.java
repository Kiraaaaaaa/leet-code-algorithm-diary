package program;

import java.util.Arrays;

public class is_unique_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUnique_1("abcc"));
    }
    public static class Solution{
        //最简单的解法之一1.利用数组坐标统计字母数量
        public boolean isUnique(String astr) {
            //存26个字母的统计数量
            int[] book = new int[26];
            for (int i = 0; i < astr.length(); i++) {
                //得到该字母在数组的坐标
                int c = astr.charAt(i) - 'a';
                if(book[c]!=0){ //如果该坐标不为0则代表已存过一次
                    return false;
                }else{ //否则代表第一次存
                    ++book[c];
                }
            }
            return true;
        }
        //解法二、原理和解法一相同，但使用位运算
        public boolean isUnique_1(String astr) {
            int nums = 0; //该数用于验证所有字母。其中一个二进制位存放一种字母，0代表没有，1代表有
            for (int i = 0; i < astr.length(); i++) {
                int index = astr.charAt(i) - 'a'; //得到该字母在nums的位坐标
                if((nums & (1 << index)) != 0){ //如果该字母在nums中已存在，则返回false。(1 << index)是将1左移index位，用于唯一标记一种字母
                    return false;
                }
                nums |= (1 << index); //否则将该字母的二进制位置为1
            }
            return true;
        }
    }
}
