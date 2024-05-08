package program;

import java.util.ArrayList;
import java.util.List;

public class _658 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findClosestElements(new int[]{1,1,2,3,3,3,4,6,8,8}, 6, 1);
        System.out.println(res);
    }
    public static class Solution {
        int k, x;
        int[] arr;
        ArrayList<Integer> res;
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            this.k = k;
            this.x = x;
            this.arr = arr;
            int n = arr.length, l = 0, r = n - 1;
            res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(arr[i] == x){ //如果x在数组中，则需要初始化左指针的开始位置为x左边k个位置， r为x右边k个位置
                    if(i + 1 - k >= 0) l = i + 1 - k; //左边指针没有超过数组最左边k个位置，才初始左指针。否则是默认的0
                    if(i + k <= n) r = i + k - 1; //右边指针没有超过数组最右边k个位置，才初始右指针。否则是默认的n-1
                    find(l, r); //找到可能的区间后，寻找符合最小差值的子序列
                    break; //坑点：[1,1]，有两个元素只以第一个元素为x
                }
            }
            if(res.size() == 0) find(l, r); //如果x不在数组中，则l默认为0，r默认为n-1，从数组两端开始扫描
            return res;
        }
        //给定左指针，右指针，去寻找符合最小差值的子序列，每次循环时删除两指针中差值最大元素
        private void find(int l, int r) {
            while(r - l + 1 != k){ //只要两区间间隔不等于k，就一直移动其中一方指针
                int left = Math.abs(arr[l] - x); //左指针差值 //坑点：差值可能为负数，所以需要转换为绝对值
                int right = Math.abs(arr[r] - x); //右指针差值 //坑点：差值可能为负数，所以需要转换为绝对值
                if(left <= right) r--; //如果左边差值更小，则右指针左移一位
                else l++; //如果右边差值更小，则左指针右移一位
            }
            while(l <= r) res.add(arr[l++]); //最小的这几个差值所在元素即答案
        }
    }
}
