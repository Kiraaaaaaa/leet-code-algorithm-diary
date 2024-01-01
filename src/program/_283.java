package program;

import java.util.Arrays;

public class _283 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,1,1};
        solution.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public static class Solution{
        //思路：遍历当前元素，如果该元素不为0，就让该元素以当前位置为起点移动到从右到左遇到的第一个不为0的元素的后面，并将自身标记为0。
        //如果前面全是为0的元素，则将当前元素放到最前面的那个0元素的位置，并将自身标记为0。
        public void moveZeroes(int[] nums) {
            if(nums.length == 1) return;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=0 && i!=0){ //如果数组第一个元素不为0，并且不是第一个元素才需要判断
                    int pre = i-1; //拿到前一个元素的下标
                    while(pre>0 && nums[pre] == 0){ //在数组坐标以内不断向前寻找第一个不为0的元素
                        --pre;
                    }
                    if(nums[pre] == 0){ //情况1.该元素之前并不存在一个不为0的元素
                        nums[pre] = nums[i]; //则将当前元素放到最前面的那个0元素
                        nums[i] = 0; //并且让当前元素清空为0
                    }else{
                        //情况2.该元素之前存在一个不为0的元素
                        nums[pre+1] = nums[i]; //由于pre当前指向的是找到的第一个不为0的元素的下标，所以将当前元素放到pre+1的位置
                        if(pre+1 != i){ //排除[1,1]两个元素相邻的情况，只有间距大于1的情况才需要清空当前元素为0
                            nums[i] = 0;
                        }
                    }
                }
            }
        }
    }
}
