package program;

import java.util.ArrayList;
import java.util.List;

public class _1441 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.buildArray_2(new int[]{2,3}, 3);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.从后往前模拟(使用计数器)
        public List<String> buildArray(int[] target, int n) {
            int N = target.length;
            ArrayList<String> res = new ArrayList<>();
            n = target[N-1]; //计数器赋值为数组最后一个整数
            for(int i = target.length-1; i >= 0; i--){ //从后往前开始模拟
                if(target[i] == n){ //如果当前数字等于计数器，则Push
                    res.add(0, "Push");
                }else{ //否则，先Pop当前数字和计数器的间隔数量，再Push相同的间隔数量，最后再Push当前数字
                    int num = n - target[i]-1; //计算和当前数字之间间隔了多少个数字
                    for (int j = 0; j < num*2; j++) { // 间隔了几个数字就有多少个Pop和Push
                        res.add(0, j%2 == 0 ? "Pop" : "Push");
                    }
                    res.add(0, "Push"); //最将当前数字Push进去
                    n = target[i]; //由于当前数字和之间的数字已经全部Push进去了，所以计数器直接更新为当前数字
                }
            }
            //如果计数器大于1，那么还需要把之前的值push/pop
            for (int i = 2; i < n * 2; i++) {
                res.add(0, i%2 == 0 ? "Pop" : "Push");
            }
            return res;
        }
        //方法2.从前往后模拟数字(使用计数器)
        public List<String> buildArray_1(int[] target, int n) {
            int count = 1; //计数器
            int index = 0; //当前数的坐标
            ArrayList<String> res = new ArrayList<>();
            while(index < target.length){
                int num = target[index]; //获得当前数
                res.add("Push");
                if(num != count){
                    res.add("Pop");
                }else{
                    ++index;
                }
                ++count;
            }
            return res;
        }
        //方法3.数学的方式，只需要根据原数组上的数字直接计算就能得到结果
        public List<String> buildArray_2(int[] target, int n) {
            ArrayList<String> res = new ArrayList<>();
            int N = target.length;
            for(int i = 0; i < N; i++){
                if(i == 0 && target[i] > 1){ //如果数组第一位前面还有数字，那么先Push和Pop前面的数字
                    for(int j = 0; j < (target[i]-1)*2; j++){
                        res.add(j % 2 == 0 ? "Push" : "Pop");
                    }
                }
                res.add("Push"); //先Push当前数字
                if(i == N-1) break; //如果当前数字是数组的最后一个数字，那么只需要Push自身即可
                int num = target[i + 1] - target[i] - 1; //计算该数字与下一个数字的差值
                for (int j = 0; j < num * 2; j++) { //间隔了几个数字就Push和Pop了多少次
                    res.add(j % 2 == 0 ? "Push" : "Pop");
                }
            }
            return res;
        }
    }
}
