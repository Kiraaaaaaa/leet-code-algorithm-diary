package program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.generate(5);
        System.out.println(list);
    }
    public static class Solution{
        //解法1：数学计算
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                //新建一个临时数组
                ArrayList<Integer> temp = new ArrayList<>();
                //临时数组的长度随着i的增大而增大
                for (int j = 0; j <= i; j++) {
                    //如果临时数组的指针是其第一个元素或者最后一个元素，则默认填充为1
                    if(j == 0 || j == i){
                        temp.add(1);
                    }else{
                        //否则就是中间的元素，而中间的元素可以动态算出(即该坐标的元素值为前一个元素和当前元素值之和)
                        //i-1拿到上一层的数组，j-1拿到上一位元素
                        temp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                    }
                }
                ans.add(temp);
            }
            return ans;
        }
    }
}
