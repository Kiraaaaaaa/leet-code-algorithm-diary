package test;

import program._2938;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Solution so = new Solution();
        long res = so.method(1, 3);
        System.out.println(res);
    }
    static class Solution {
        //方法1.枚举三路车的个数
        public long method(int x, int y) {
            int res = -1;
            for (int i = 0; i <= x; i++) {
                if(y == i*3 + (x-i)*4){
                    res = i;
                    break;
                }
            }
            return res;
        }
    }
}
