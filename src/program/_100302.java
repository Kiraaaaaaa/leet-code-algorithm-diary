package program;

public class _100302 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxPointsInsideSquare(new int[][]{{-2,4},{9,3},{-9,3}}, "cca");
        System.out.println(res);
    }
    public static class Solution {

        //方法1(超时).和其他点比较，时间复杂度O(n^2)
        public int maxPointsInsideSquare(int[][] points, String s) {
            int m = points.length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                boolean[] vis = new boolean[26]; //用于记录该圈内已经被包含过的字母
                int x = points[i][0]; //当前点的x坐标
                int y = points[i][1]; //当前点的y坐标
                char c = s.charAt(i); //当前点的字母
                vis[c-'a'] = true; //当前点的字母标记为已包含
                int count = 1; //当前圈内点数
                int len = Math.max(Math.abs(x), Math.abs(y)); //当前圈的边长
                boolean flag = true; //该圈内是否有重复的字母
                for (int j = 0; j < m; j++) {
                    if(i == j) continue; //需要跳过自己，判断其它点是否在圈内
                    int x1 = points[j][0];
                    int y1 = points[j][1];
                    char c1 = s.charAt(j);
                    if(Math.abs(x1) <= len && Math.abs(y1) <= len){ //判断点是否在圈内
                        if(vis[c1-'a']){ //判断字母是否重复包含
                            flag = false; //有重复则跳出循环，并标记为非法的圈
                            break;
                        }
                        count++; //圈内点数+1
                        vis[c1-'a'] = true; //标记为已包含当前字母
                    }
                }
                if(flag){
                    res = Math.max(count, res); //如果圈内没有重复字母，则更新最大值
                }
            }
            return res;
        }
    }
}
