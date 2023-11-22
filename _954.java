package 刷题;
import java.util.*;

public class _954 {
    static class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int x : arr) {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
            System.out.println(cnt);
            if (cnt.getOrDefault(0, 0) % 2 != 0) { //如果有奇数个0则无法匹配成功
                return false;
            }

            List<Integer> vals = new ArrayList<Integer>();
            for (int x : cnt.keySet()) {
                vals.add(x);
            }
            Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));
            System.out.println(vals);
            for (int x : vals) {
                if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                    return false;
                }
                cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
            }
            System.out.println(cnt);
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr={2,1,2,4,0,0};
        Solution solution = new Solution();
        System.out.println(solution.canReorderDoubled(arr));
    }
}
