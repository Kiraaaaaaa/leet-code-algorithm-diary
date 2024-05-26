package program;

public class _100289 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minimumSubstringsInPartition("abababaccddb");
        System.out.println(res);
    }
    public static class Solution {
        int len;
        int res = Integer.MAX_VALUE;
        char[] charArray;
        //方法1(超时).dfs回溯
        public int minimumSubstringsInPartition(String s) {
            len = s.length();
            charArray = s.toCharArray();
            dfs( 0, 0); // 从第0个字符开始，当前已经分割的字符串个数
            return res;
        }
        private void dfs(int index, int num) {
            if (index == len) {
                res = Math.min(res, num);
                return;
            }
            for (int i = index; i < len; i++) {
                // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否出现次数相同
                if (!check(charArray, index, i)) {
                    continue; // 不是符合规则的子串，直接跳过
                }
                dfs(i + 1, num + 1); // 继续遍历下一个字符
            }
        }
        private boolean check(char[] charArray, int left, int right) {
            if(left == right) return true;
            int[] count = new int[26];
            for (int i = left; i <= right; i++) {
                count[charArray[i]-'a']++;
            }
            for (int i = left+1; i <= right; i++) {
                if(count[charArray[i]-'a'] != count[charArray[i-1]-'a']) return false;
            }
            return true;
        }
    }
}
