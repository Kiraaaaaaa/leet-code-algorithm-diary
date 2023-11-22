package program;

public class _45 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,1,1,4};
        int ans = solution.jump(nums);
        System.out.println(ans);
    }
    public static class Solution {
        /**
         * 思路：
         * 由于题目是必到数组末尾的，所以不考虑边界问题直接开始
         * 从第一个位置开始遍历，得到当前位置的到可达地址，在这个地址范围内就是区间1
         * 从第一个区间1开始依次遍历，遍历区间内每个位置的可到达地址，即可以得到一个新的区间2，区间2则是下一步的起跳范围
         * 在此期间如果指针到达本区间即区间1的最后一个位置，则更新区间2的结束地址为区间2的最后一个地址
         * 此时代表区间1已经走过，步数此时为1
         * 开始继续遍历区间2，在遍历过程中同样可以得到一个区间3，维护着最远可到地址
         * 区间2结束后，步数+1=2
         * [优化点]
         * 比如一共有两个区间，在遍历区间1时就在计算下一个区间2的最大值了，如果在此期间最大值已经超过原数组的大小，
         * 说明不用再继续遍历下一个区间2里元素的可到达范围了，直接当前步数1+1=2，即两步就可以到达末尾
         * @param nums
         * @return
         */
        public int jump(int[] nums) {
            int ans = 0;
            int end = 0;
            int maxPos = 0;
            for(int i=0; i<nums.length-1; i++){
                //得到当前步数内可以到达的最远位置，即下一个区间的最远距离
                maxPos = Math.max(maxPos, nums[i]+i);
                //优化，如果当前区间以内步数可以到达末尾则不需要继续遍历后面的元素了，直接当前步数+1即可
                if(maxPos >= nums.length-1){
                    return ans+1;
                }
                // 如果指针到达当前步数内的最远位置
                // 则更新下一个区间的最远位置为当前步数内可到达的最远位置
                // 到这里就已经说明可以开启下一步了，当前步数+1
                if(i==end){
                    end = maxPos;
                    ans++;
                }
            }
            return ans;
        }
    }
}
