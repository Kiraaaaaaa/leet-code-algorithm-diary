package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _2831 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.longestEqualSubarray_1(new ArrayList<>(List.of(1,3,2,3,1,3)), 3);
        System.out.println(res);
    }
    public static class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int n = nums.size();
            List<Integer>[] posLists = new ArrayList[n + 1];
            Arrays.setAll(posLists, i -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                int x = nums.get(i);
                posLists[x].add(i - posLists[x].size());
            }

            int ans = 0;
            for (List<Integer> pos : posLists) {
                if (pos.size() <= ans) {
                    continue; // 无法让 ans 变得更大
                }
                int left = 0;
                for (int right = 0; right < pos.size(); right++) {
                    while (pos.get(right) - pos.get(left) > k) { // 要删除的数太多了
                        left++;
                    }
                    ans = Math.max(ans, right - left + 1);
                }
            }
            return ans;
        }

        //方法1.滑动窗口
        public int longestEqualSubarray_1(List<Integer> nums, int k) {
            int n = nums.size();
            int res = 0;
            // lists记录某数字在nums中出现过的位置
            List[] lists = new ArrayList[n+1];
            Arrays.setAll(lists, i -> new ArrayList());
            for (int i = 0; i < n; i++) {
                Integer x = nums.get(i);
                // 记录位置，示例1中3的位置将被记录为[1,2,3]
                lists[x].add(i - lists[x].size());
            }
            // 遍历出现的每个数字的坐标集合，滑动窗口获取最大值
            for (List<Integer> pos : lists) {
                // 如果当前数字的出现次数小于当前最大子数组长度，则不可能组成更大的子数组，直接跳过
                if(pos.size() <= res){
                    continue;
                }
                // 定义一个滑动窗口
                for (int left = 0, right = 0; right < pos.size(); right++) {
                    // 如果该数的两坐标间隔超过了k个数则无法组成子数组，左指针右移，尝试该数其它子数组
                    if(pos.get(right) - pos.get(left) > k){
                        left++;
                    }
                    // 尝试更新最大子数组长度
                    res = Math.max(res, right - left + 1);
                }
            }
            return res;
        }
    }
}
