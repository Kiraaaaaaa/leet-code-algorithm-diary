package program;

import java.util.*;

public class _2342 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumSum_3(new int[]{243,205,369,253,72,484,300,161,188,69,309,96,226,308,252});
        System.out.println(res);
    }
    public static class Solution {
        //方法1.暴力，超时
        public int maximumSum(int[] nums) {
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                int sumA = getSum(nums[i]);
                for(int j = i+1; j < nums.length; j++){
                    int sumB = getSum(nums[j]);
                    if(sumA == sumB){
                        max = Math.max(nums[i] + nums[j], max);
                    }
                }
            }
            return max;
        }
        //方法2.哈希表+暴力，效率垫底
        public int maximumSum_1(int[] nums) {
            int max = -1;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            //1.以个位数和为key，拥有该和的值为value存入map
            for (int num : nums) {
                int sum = getSum(num);
                if(map.containsKey(sum)){
                    ArrayList<Integer> list = map.get(sum);
                    list.add(num);
                    map.put(sum, list);
                }else{
                    map.put(sum, new ArrayList<>(List.of(num)));
                }
            }
            //2.对于拥有一样个位数和的所有数，两两相加暴力得到最大值
            for (ArrayList<Integer> list : map.values()) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i+1; j < list.size(); j++) {
                        max = Math.max(list.get(i)+list.get(j), max);
                    }
                }
            }
            return max;
        }
        //方法3.对方法2的改进，value存的同样还是list，但是list存的是最大的两个数
        //不错不错，效率倒数了
        public int maximumSum_2(int[] nums) {
            int max = -1;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            //1.以个位数和为key，拥有该和的值为value存入map
            for (int num : nums) {
                int sum = getSum(num);
                if(map.containsKey(sum)){
                    if(map.get(sum).size() == 2){ //如果map中已经存在该和的数，但是已经有两位了，替换最大的那个
                        map.get(sum).add(num);
                        Collections.sort(map.get(sum)); //添加后排序
                        map.get(sum).remove(0); //删除最小的那个
                    }else{ //如果map中已经存在该和的数，但是只有一位，则添加当前的数
                        map.get(sum).add(num);
                    }
                }else{ //如果map中不存在该和的数，则新建一个list，然后添加当前的数
                    map.put(sum, new ArrayList<>(List.of(num)));
                }
            }
            //2.对于拥有两个数的list，因为是最大值所以直接相加即可
            for (ArrayList<Integer> list : map.values()) {
                if(list.size() == 2) max = Math.max(list.get(0)+list.get(1), max);
            }
            return max;
        }
        //最好的方法4.维护左最大值，枚举右与最大值相加
        public int maximumSum_3(int[] nums) {
            int max = -1;
            int[] count = new int[82];//个位数相加最多为81，同时维护目前为止最大的一个数
            for (int num : nums) {
                int sum = getSum(num);
                //如果该数左边有一样个位数和的数，则更新相加的最大值
                if(count[sum]>0){
                    max = Math.max(count[sum]+num, max);
                }
                //同时维护该个位数和的最大值
                count[sum] = Math.max(count[sum], num);
            }
            return max;
        }
        //获取个位数和
        public int getSum(int num) {
            int sum = 0;
            for(int n = num; n!=0; n/=10) sum += n % 10;
            return sum;
        }
    }
}
