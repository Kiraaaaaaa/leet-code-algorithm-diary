package 刷题;

import java.util.*;

public class _36 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        char[][] board = new char[][]{
                {'.','.','5','.','.','.','.','.','.'},
                {'.','.','.','8','.','.','.','3','.'},
                {'.','5','.','.','2','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','9'},
                {'.','.','.','.','.','.','4','.','.'},
                {'.','.','.','.','.','.','.','.','7'},
                {'.','1','.','.','.','.','.','.','.'},
                {'2','4','.','.','.','.','9','.','.'}
        };
        boolean b = solution.isValidSudoku(board);
        System.out.println(b);
    }

    public static class Solution {
        public boolean isValidSudoku(char[][] board) {
            //存储行中出现的数字
            HashMap<Integer, HashMap<Character, Boolean>> rowMap = initMap();
            //存储列中出现的数字
            HashMap<Integer, HashMap<Character, Boolean>> colMap = initMap();
            //所有区间的坐标范围
            HashMap<Integer, int[]> rangeMap = getRange();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    //num为当前数字
                    char num = board[i][j];
                    //如果是'.'跳过以下所有行列比较的步骤
                    if(num != '.'){
                        //1.查看该行是否有此数
                        //获取该行存储的数字
                        HashMap<Character, Boolean> numOnRowMap = rowMap.get(i);
                        //存在该数说明在行上重复了
                        if(numOnRowMap.containsKey(num)){
                            return false;
                        }else{
                            //没有就把该数存进行该列的数据集
                            numOnRowMap.put(num, true);
                        }

                        //2.查看该列是否有此数
                        //获取该列存储的数字
                        HashMap<Character, Boolean> numOnColMap = colMap.get(j);
                        //存在该数说明在列上重复了
                        if(numOnColMap.containsKey(num)){
                            return false;
                        }else{
                            //没有就把该数存进行该列的数据集
                            numOnColMap.put(num, true);
                        }
                    }

                    //3.查看该区块是否有此数
                    for (int k = 0; k < 9; k++) {
                        int iMin = rangeMap.get(k)[0];
                        int iMax = rangeMap.get(k)[1];
                        int jMin = rangeMap.get(k)[2];
                        int jMax = rangeMap.get(k)[3];
                        //找到该区间，遍历出其他几位的数字
                        if(iMin <= i && i <= iMax && jMin <= j && j <= jMax){
                            for (int iBlock = iMin; iBlock <= iMax; iBlock++) {
                                for(int jBlock = jMin; jBlock <= jMax; jBlock++){
                                    //如果
                                    if(num == board[iBlock][jBlock] && i != iBlock && j!= jBlock && num != '.'){
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // System.out.println(rowMap);
            return true;
        }
        //初始化一个map对象，key为行或列号，value的key为数字，value的value为是否存在的布尔值，实际上并未用到，冗余做填充用(根据它的key就能判断是否存在)
        private HashMap<Integer, HashMap<Character, Boolean>> initMap(){
            HashMap<Integer, HashMap<Character, Boolean>> map = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                //初始化一个元素
                map.put(i, new HashMap<Character, Boolean>());
            }
            return map;
        }
        //初始化九大区块各自的区间取值
        private HashMap<Integer, int[]> getRange(){
            //第一位：行坐标最小值
            //第二位：行坐标最大值
            //第三位：列坐标最小值
            //第四位：列坐标最大值
            int[] range = new int[]{0, 2, 0, 2};
            int num = 0;
            HashMap<Integer, int[]> rangeMap = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //坑点来了
                    //rangeMap.put(num++, range);
                    //由于存range是一个上文定义出的数组，导致指针都指向一个内存空间，如果这样最后你会发现value都是同一个值
                    //所以采用匿名数组解决，你也可以使用arrays.copyOf()
                    rangeMap.put(num++, new int[]{range[0], range[1], range[2], range[3]});
                    range[0] += 3;
                    range[1] += 3;
                }
                //记得换行重置一下行坐标的区间
                range[0] = 0;
                range[1] = 2;
                //换行增加列坐标区间
                range[2] += 3;
                range[3] += 3;
            }
            return rangeMap;
        }
    }
}
