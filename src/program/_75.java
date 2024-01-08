package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _75 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,0,2,1,1,0};
        solution.sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static class Solution{
        public void sortColors(int[] nums) {
            int[] a = new int[3];
            ArrayList<Integer> res = new ArrayList<>();
            for (int num : nums) {
                ++a[num];
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i]; j++) {
                    res.add(i);
                }
            }
        }
    }
}
