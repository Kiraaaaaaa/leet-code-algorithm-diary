package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2951 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> peaks = solution.findPeaks(new int[]{1,4,3,8,5});
        System.out.println(peaks);
    }
    public static class Solution{
        public List<Integer> findPeaks(int[] mountain) {
            ArrayList<Integer> list = new ArrayList<>();
            int len = mountain.length - 2;
            for (int i = 1; i <= len; i++) {
                int pre = mountain[i - 1];
                int next = mountain[i + 1];
                int cur = mountain[i];
                if(pre < cur && next < cur){
                    list.add(i);
                    ++i;
                }
            }
            return list;
        }
    }
}
