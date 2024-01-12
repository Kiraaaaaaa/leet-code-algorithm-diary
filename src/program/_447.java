package program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _447 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(res);
    }
    public static class Solution {
        //方法1：暴力模拟
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                int ix = points[i][0], iy = points[i][1]; //选取点1
                for (int j = i+1; j < points.length; j++) {
                    int jx = points[j][0], jy = points[j][1]; //选取点2
                    for (int k = j+1; k < points.length; k++) {
                        int kx = points[k][0], ky = points[k][1]; //选取点3
                        //计算点1到点2的距离的平方
                        int dij = (ix-jx)*(ix-jx) + (iy-jy)*(iy-jy);
                        //计算点1到点3的距离的平方
                        int dik = (ix-kx)*(ix-kx) + (iy-ky)*(iy-ky);
                        //计算点2到点3的距离的平方
                        int djk = (jx-kx)*(jx-kx) + (jy-ky)*(jy-ky);
                        //如果点1到点2和点1到点3的距离相等，则说明有两种结果，其它同理
                        if(dij == dik) res += 2;
                        if(dij == djk) res += 2;
                        if(dik == djk) res += 2;
                    }
                }
            }
            return res;
        }
    }
}
