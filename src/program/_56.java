package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] merge = solution.merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        if(merge != null){
            Arrays.stream(merge).forEach(i-> {
                Arrays.stream(i).forEach(System.out::println);
                System.out.println();
            });
        }
    }
    public static class Solution {
        public int[][] merge(int[][] intervals) {
            int m = intervals.length;
            //对数组按照最小值起始值排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int first = intervals[0][0], second = intervals[0][1]; //区间最小值，区间最大值
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //存放合并后的区间
            for (int i = 1; i < m; i++) {
                if (intervals[i][0] <= second){ //如果和上个区间有重叠
                    if(intervals[i][1] > second){ //如果当前最大值大于区间的最大值，则更新最大值
                        second = intervals[i][1];
                    }
                } else { //如果没有重叠
                    list.add(new ArrayList<>(List.of(first, second))); //将上一个区间加入list
                    first = intervals[i][0]; //更新区间最小值
                    second = intervals[i][1]; //更新区间最大值
                }
            }
            list.add(new ArrayList<>(List.of(first, second))); //将最后一个区间加入list
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0] = list.get(i).get(0);
                res[i][1] = list.get(i).get(1);
            }
            return res;
        }
    }
}
