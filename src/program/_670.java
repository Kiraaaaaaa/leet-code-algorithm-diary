package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _670 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumSwap(1111);
        System.out.println(res);
    }
    public static class Solution {
        //思路：
        //先复制一份数组出来从大到小排序，排序后找到第一个和原数组值不同的坐标，这就就是待交换的第一个值
        //然后记录下这个坐标在排序后数组中的值，继续在原数组中寻找和这个值相等的值的坐标，这就是待交换的第二个值
        //最后交换记录下的第一个值和第二个值的坐标的数字即可。
        public int maximumSwap(int num) {
            String s = String.valueOf(num);
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i)); //转为动态数组方便排序
            }
            Collections.sort(list, Collections.reverseOrder()); //从大到小排序，只为了找到第一个需要交换的数
            int swapA = -1, b = -1, swapB = -1; //待交换的第一个坐标，待交换的第二个数的坐标
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != list.get(i) && swapA == -1){
                    swapA = i; //找到待交换的第一个坐标
                    b = list.get(i); //找到待交换的第二个数
                }
                if(s.charAt(i) == b) swapB = i; //找到待交换的第二个数的坐标，贪心找到相等的其最后一位
            }
            if(swapA != -1) { //有不同的数才需要进行交换
                char[] chars = s.toCharArray();
                char temp = chars[swapA];
                chars[swapA] = chars[swapB];
                chars[swapB] = temp;
                s = String.valueOf(chars);
            };
            return Integer.valueOf(s);
        }
    }
}
