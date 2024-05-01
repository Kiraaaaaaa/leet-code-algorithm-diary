package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1313 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.decompressRLElist(new int[]{1, 2, 3, 4});
        Arrays.stream(res).forEach(System.out::print);
    }

    public static class Solution {

        //方法1.模拟即可，调用了下stream流来转数组
        public int[] decompressRLElist(int[] nums) {
            int n = nums.length;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i+=2) {
                for (int j = 0; j < nums[i]; j++) {
                    list.add(nums[i+1]);
                }
            }
            int[] res = list.stream().mapToInt(i -> i).toArray();
            return res;
        }
    }
}
