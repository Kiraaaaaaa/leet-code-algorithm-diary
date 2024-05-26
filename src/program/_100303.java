package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _100303 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public static class Solution {

        //方法1.动态数组存储x出现过的位置
        public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
            ArrayList<Integer> list = new ArrayList<>();
            int[] res = new int[queries.length];
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == x){
                    list.add(i);
                }
            }
            for (int i = 0, queriesLength = queries.length; i < queriesLength; i++) {
                int query = queries[i];
                if (list.size() < query) {
                    res[i] = -1;
                }else{
                    res[i] = list.get(query - 1);
                }
            }
            return res;
        }
    }
}
