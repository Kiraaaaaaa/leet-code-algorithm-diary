package program;

import java.util.Arrays;
import java.util.HashSet;

public class _2171 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long res = solution.minimumRemoval(new int[]{4, 1, 6, 5});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.计算矩形最大的面积(从小到大枚举每一个存在的元素)
        public long minimumRemoval(int[] beans) {
            Arrays.sort(beans);
            long sum = 0, mx = 0;
            int n = beans.length;
            for (int i = 0; i < n; i++) {
                sum += beans[i];
                mx = Math.max(mx, (long) (n - i) * beans[i]);
            }
            return sum - mx;
        }
    }
}
