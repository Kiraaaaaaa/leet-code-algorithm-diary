package program;

public class _167 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rs = solution.twoSum(new int[]{1, 2, 3, 6, 7}, 5);
        System.out.println(rs[0]+" "+rs[1]);
    }

    /**
     * 思路：由于数组是有序的，所以可以双指针来解决。
     * 两指针指向的数相加之和如果大于目标值，则右指针左移
     * 如果小于目标值，则左指针右移
     */
    public static class Solution{
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length-1;
            while(left<=right){
                if(numbers[left]+numbers[right] == target) return new int[]{left+1, right+1}; //如果找到了其中一种可能就直接返回，没有必要继续搜索
                if(numbers[left]+numbers[right] > target) --right; //如果相加之和大于目标值，则右指针左移
                if(numbers[left]+numbers[right] < target) ++left; //如果相加之和小于目标值，则左指针右移
            }
            return null;
        }
    }
}
