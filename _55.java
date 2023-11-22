package 刷题;

public class _55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,1,1,4};
        boolean b = solution.canJump(nums);
        System.out.println(b);
    }
    public static class Solution{
        /**
         * 解题思路：
         * 维护从坐标0开始，不断维护一个最大可到达值max，即可以跳跃到的位置
         * 如果这个位置能到达或者超过最后一个位置则成功，否则失败
         * 注意需要判断i的遍历一定要截止到最长步数以内，它是不断动态变化的
         * 
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            //最远可到坐标
            int maxIndex = 0;
            for (int i = 0; i < nums.length-1; i++) {
                // 如果当前坐标可到达的地方远于正在维护的最远可到坐标
                // && 该坐标在最远可到坐标内
                // 则更新最远可到坐标
                System.out.println(i+" "+maxIndex);
                if(nums[i]+i > maxIndex && i <= maxIndex){
                    System.out.println(i+" "+maxIndex);
                    maxIndex = nums[i] + i;
                }
            }

            return maxIndex>=nums.length-1;
        }
    }
}
