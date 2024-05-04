package program.各种排序;

import java.util.ArrayList;
import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 6, 7, 8, 9, 10};
        new Solution().bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    private static class Solution {
        public void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if(arr[j] > arr[j + 1]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
}
