package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _75 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,0,2,1,1,0};
        solution.sortColors_1(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static class Solution{
        int[] count;
        public void sortColors(int[] nums) {
            count = new int[3];
            for (int i = 0; i < nums.length; i++) {
                count[nums[i]]++;
            }
            Arrays.fill(nums, 0, count[0], 0);
            Arrays.fill(nums, count[0], nums.length, 1);
            Arrays.fill(nums, count[0] + count[1], nums.length, 2);
        }

        //方法2.一次遍历，用1去覆盖2，用0去覆盖1
        public void sortColors_1(int[] nums) {
            int num0 = 0, num1 = 0, num2 = 0; //记录0，1，2的指针
            //三个指针，分别指向每个颜色的起始位置，并更替重新生成新的数组
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    nums[num2++] = 2;
                    nums[num1++] = 1;
                    nums[num0++] = 0;
                }else if(nums[i] == 1) {
                    nums[num2++] = 2;
                    nums[num1++] = 1;
                }else {
                    nums[num2++] = 2;
                }
                for (int num : nums) {
                    System.out.print(num);
                }
                System.out.println();
            }
        }
    }
}
