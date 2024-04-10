package program;

public class _2938 {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.minimumSteps_1("101");
        System.out.println(res);
    }
    static class Solution {
        //方法1.双指针。可以不考虑1移动到最右点的过程，而只需要计算每一个0到达最左点的距离
        public long minimumSteps(String s) {
            long res = 0;
            for (int l = 0, r = 0; r < s.length(); r++) { //l指针记录0要移动到最左边的位置，r指针用来遍历字符串每一位
                if(s.charAt(r) == '0') res += r - l++; //0移动到最左端，l指针右移一位
            }
            return res;
        }
        //方法2.冒泡排序（超时）
        public long minimumSteps_1(String s) {
            int res = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = 0; j < chars.length - i - 1; j++) {
                    if(chars[j] > chars[j+1]){
                        chars[j] = '0';
                        chars[j+1] = '1';
                        res++; //两两交换的次数的就是移动次数
                    }
                }
            }
            return res;
        }
    }
}
