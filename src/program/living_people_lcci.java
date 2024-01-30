package program;

import java.util.ArrayDeque;

public class living_people_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
            int res = solution.maxAliveYear(new int[]{1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901}, new int[]{1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969});
        System.out.println(res);
    }
    public static class Solution {
        public int maxAliveYear(int[] birth, int[] death) {
            int[] count = new int[birth.length];
            int max = 0;
            for (int i = 0; i < birth.length; i++) {
                for(int j = 0; j < birth.length; j++){
                    if(i == j) continue;
                    if(birth[j] <= birth[i]){
                        count[i]++;
                        if(count[i] > count[max]){
                            max = i;
                        }else if(count[i] == count[max] && birth[i] > birth[max]){
                            max = i;
                        }
                    }
                }
            }
            for (int i = 0; i < count.length; i++) {
                System.out.println(count[i]);
            }
            return birth[max];
        }
    }
}
