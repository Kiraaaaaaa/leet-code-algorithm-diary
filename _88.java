package 刷题;

public class _88 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,0,0,0};
        solution.merge(nums, 3, new int[]{2,5,6}, 3);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    public static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] result = new int[m+n];
            int cur1 = 0, cur2 = 0, num;
            while (cur1 < m || cur2 < n){
                if(cur1 == m){
                    num = nums2[cur2];
                    cur2++;
                }
                else if(cur2 == n){
                    num = nums1[cur1];
                    cur1++;
                }
                else if(nums1[cur1] <= nums2[cur2]){
                    num = nums1[cur1];
                    cur1++;
                }
                else{
                    num = nums2[cur2];
                    cur2++;
                }
                result[cur1 + cur2 - 1] = num;
            }
            for (int i = 0; i < result.length; i++) {
                nums1[i] = result[i];
            }
        }
    }
}
