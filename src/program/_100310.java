package program;

public class _100310 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isArraySpecial(new int[]{2, 1, 4});
        System.out.println(res);
    }
    public static class Solution {

        //方法1.个人写法，判断第一个数字是奇数还是偶数，然后采取不同的逻辑。如果是奇数，则偶数位置的数字必须为偶数，奇数位置的数字必须为奇数，反之亦然。
        public boolean isArraySpecial(int[] nums) {
            int n = nums.length;
            if(n == 1) return true;
            boolean firstSingle = (nums[0] & 1) == 1;
            if(firstSingle) {
                for (int i = 1; i < n; i+=2) {
                    if((nums[i] & 1) != 0) return false;
                }
                for (int i = 0; i < n; i+=2) {
                    if((nums[i] & 1) != 1) return false;
                }
            } else {
                for (int i = 1; i < n; i+=2) {
                    if((nums[i] & 1) != 1) return false;
                }
                for (int i = 0; i < n; i+=2) {
                    if((nums[i] & 1) != 0) return false;
                }
            }
            return true;
        }

        //方法2.前后元素两两比较，只要奇偶性一致则是特殊数组
        public boolean isArraySpecial_1(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if((nums[i]&1) == (nums[i-1]&1)) return false;
            }
            return true;
        }
    }
}
