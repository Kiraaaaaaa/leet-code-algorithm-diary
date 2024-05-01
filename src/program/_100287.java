package program;

import java.util.Arrays;

public class _100287 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.minimumAddedInteger(new int[]{3,5,5,3}, new int[]{7, 7, 7});
        System.out.println(re);
    }
    public static class Solution {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums2);
            Arrays.sort(nums1);
            int base = nums2[0];
            int res = Integer.MAX_VALUE;
            int[] vis = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                vis[i] = 1; // 第一个被移除的位置
                for (int j = i+1; j < nums1.length; j++) {
                    vis[j] = 1; // 第二个被移除的位置
                    int x = 0; // 差值
                    boolean isX = true; // 是否是符合的差值
                    int cur = 0;
                    for (int k = 0; k < nums1.length; k++) { // 遍历nums1所有数，得到和nums2中两两相差的值, 判断是否一致
                        if(vis[k] != 1 && cur == 0){ //如果是第一个位置，则直接减去
                            x = base - nums1[k]; //当前nums1最小的数 - nums2最小的数 = 差值
                            cur++;
                        }else if(vis[k] != 1){
                            if(x != nums2[cur] - nums1[k]) isX = false;
                            cur++;
                        }
                    }
                    if(isX) res = Math.min(x, res);
                    vis[j] = 0; // 恢复第二个位置
                }
                vis[i] = 0; // 恢复第一个位置
            }
            return res;
        }
    }
}
