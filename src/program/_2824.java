package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2824 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPairs_1(new ArrayList<>(List.of(-1,1,2,3,1)), 2));
    }
    static class Solution {
        private int res;
        //方法1.暴力
        public int countPairs(List<Integer> nums, int target) {
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    if(nums.get(i) + nums.get(j) < target) res++;
                }
            }
            return res;
        }
        public int countPairs_1(List<Integer> nums, int target) {
            Collections.sort(nums);
            int res = 0;
            for (int i = 1; i < nums.size(); i++) {
                int k = binarySearch(nums, 0, i - 1, target - nums.get(i));
                res += k;
            }
            return res;
        }
        //方法2.二分查找
        public int binarySearch(List<Integer> nums, int lo, int hi, int target) {
            int res = hi + 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums.get(mid) >= target) {
                    res = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return res;
        }

    }
}
