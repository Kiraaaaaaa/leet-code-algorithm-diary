package program;

public class _137 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.singleNumber(new int[]{2,2,3,2});
        System.out.println(res);
    }
    public static class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int total = 0;
                for (int num : nums) {
                    //开始积累nums中到目前为止在第i位为1的数量
                    total += (num>>i)&1;
                }
                //如果total不是3的倍数，说明第i位为1，代表答案在第i位有值
                if(total%3 != 0){
                    //将1左移i个位置，将目前答案中的第i个位置赋值为1
                    ans |= (1<<i);
                }
            }
            return ans;
        }
    }
}
