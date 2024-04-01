package program;

public class _303 {
    public static void main(String[] args) {
        NumArray_1 numArray = new NumArray_1(new int[]{-2, 0, 3, -5, 2, -1});
        int res = numArray.sumRange(0, 2);
        System.out.println(res);
        res = numArray.sumRange(2, 5);
        System.out.println(res);
        res = numArray.sumRange(0, 5);
        System.out.println(res);
    }
    //方法1.逐个遍历相加
    public static class NumArray {
        int[] s;
        public NumArray(int[] nums) {
            s = nums;
        }
        public int sumRange(int left, int right) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                res += s[i];
            }
            return res;
        }
    }
    //方法2.前缀和，right位置的前缀和减去left-1位置的前缀和
    public static class NumArray_1 {
        int res = 0;
        int[] map; //记录前缀和
        public NumArray_1(int[] nums) {
            map = new int[nums.length];
            map[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                map[i] = nums[i] + map[i-1]; //该坐标左边的所有值包括该位置的和
            }
        }
        public int sumRange(int left, int right) {
            if(left == 0) return map[right];
            return map[right] - map[left-1]; //返回right位置的前缀和减去left-1位置的前缀和
        }
    }
}
