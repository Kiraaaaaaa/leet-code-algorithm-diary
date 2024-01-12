package program;

public class _896 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,2};
        boolean res = solution.isMonotonic_2(arr);
        System.out.println(res);
    }
    public static class Solution{
        //方法1.自己第一次写的(感兴趣可以看)
        public boolean isMonotonic(int[] nums) {
            int last = nums[0]; //记录上一个数
            int rule = 0; //1升序，-1降序，0规则还未定义

            for (int i = 1; i < nums.length; i++) {
                if(rule == 0){ //如果还是未知规则，则会执行到知道规则为止
                    //如果当前值大于上一个值，则规则为升序
                    if(nums[i] > last) rule = 1;
                    //如果当前值小于上一个值，则规则为降序
                    if(nums[i] < last) rule = -1;
                    //只有当不知道规则时才定义上一个值
                    if(rule==0) last = nums[i];
                }
                //如果规则为升序，判断当前值是否大于上一个值
                if(rule == 1){
                    if(nums[i] >= last){ //是则更新
                        last = nums[i];
                    }else{
                        return false;
                    }
                }
                //如果规则为降序，判断当前值是否小于上一个值
                if(rule == -1){
                    if(nums[i] <= last){ //是则更新
                        last = nums[i];
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
        //方法2.判断是否同时满足过两种规则
        public boolean isMonotonic_1(int[] nums) {
            boolean in = false, de = false;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] < nums[i-1]) in = true;
                if(nums[i] > nums[i-1]) de = true;
            }
            //这三种情况分别是：
            //1.所有元素值都一样(即两种规则都不满足)
            //2.只满足升序
            //3.只满足降序
            return (!in && !de) || (in && !de) || (!in && de);
        }
        //方法3.在方法2上，逆向思维稍加改造，代码变得更简洁
        public boolean isMonotonic_2(int[] nums){
            boolean in = true, de = true;
            for (int i = 1; i < nums.length && (in||de); i++) {
                if(nums[i] < nums[i-1]) de = false;
                if(nums[i] > nums[i-1]) in = false;
            }
            return (in||de);
        }
        //方法4.根据第一个值和最后一个值判断是升序还是降序，为什么？因为中间的两个元素可能相等，而你不知道他们什么时候会发生变化，所以直接取第一位和最后一位就可以直接得知排序规则
        public boolean isMonotonic_3(int[] nums) {
            //递增情况
            if(nums[0] <= nums[nums.length-1]) {
                for (int i = 0; i < nums.length-1; i++) {
                    if(nums[i]>nums[i+1]) return false;
                }
            }
            //递减情况
            if(nums[0] >= nums[nums.length-1]) {
                for (int i = 0; i < nums.length-1; i++) {
                    if(nums[i]<nums[i+1]) return false;
                }
            }
            return true;
        }
    }
}
