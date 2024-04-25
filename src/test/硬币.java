package test;

import java.util.HashSet;

public class 硬币 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.func(4, "1001");
        System.out.println(res);
    }
    static class Solution {
        //思路：按规则模拟即可，如果能组成111的情况就退出，而如果在一次翻转后的int数值之前已经有了，则说明永远不能组成111的情况。
        //举例1：110，十进制为6，把6存到set中。然后翻转第二位，还是110。然而6已经在set中存在，永远都无法变为111，退出循环
        //举例2：101，十进制为5，把5存到set中。然后翻转第二位，111。111中1的个数等于n，说明找到，退出循环
        public int func(int n, String s) {
            int res = 1; //翻转的次数，我们默认先翻转一次
            HashSet<Integer> set = new HashSet<>(); //存放被翻转过的数字
            int num = Integer.parseInt(s, 2); //先转为十进制
            int count = Integer.bitCount(num); //再统计比特位为1的个数

            if(count == n) return n; //如果全为1，则翻转n次
            if(count == 0) return 0; //如果全为0，则翻转0次
            if(n == 1 && count == 1) return 1; //如果数字只有一位，并且为1，则只需要翻转一次

            set.add(num); //set存放该数字
            char[] chars = s.toCharArray();
            chars[count-1] = '1'; //先尝试第一次翻转
            num = Integer.parseInt(String.valueOf(chars), 2);//第一次翻转结果转为十进制
            while(!set.contains(num)){ //如果当前尝试的数字没有在set中，则继续翻转
                count = Integer.bitCount(num); //统计比特位为1的个数
                set.add(num); //set存放该数字
                if(count == s.length()) break; //如果1的个数等于n，说明找到，退出循环
                chars[count-1] = '1'; //翻转
                num = Integer.parseInt(String.valueOf(chars), 2);//翻转结果转为十进制
                res++; //翻转次数+1
            }
            return count != n ? -1 : res + n; //如果最后1的个数等于n，则返回翻转次数+n，因为翻转res次后，111，翻转为000还需要n次
        }
    }
}
