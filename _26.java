package 刷题;

public class _26 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }
    public static class Solution{
        public int removeDuplicates(int[] nums) {
            int l = 0, r = 1;
            while(r<nums.length){
                if(nums[l] != nums[r]){
                    if(r-l>1){
                        nums[l+1] = nums[r];
                    }
                    l++;
                }
                r++;
            }
            return l+1;
        }
    }
}
