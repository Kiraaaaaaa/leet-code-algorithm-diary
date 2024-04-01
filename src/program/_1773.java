package program;

import java.util.*;

public class _1773 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.countMatches(Arrays.asList(
                Arrays.asList("phone", "blue", "pixel"),
                Arrays.asList("computer", "silver", "lenovo"),
                Arrays.asList("phone", "gold", "iphone")
        ), "color", "silver");
        System.out.println(res);
    }
    static class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int res = 0;
            for (List<String> item : items) {
                switch (ruleKey){
                    case "type" : if (item.get(0).equals(ruleValue)) res++; break;
                    case "color" : if (item.get(1).equals(ruleValue)) res++; break;
                    case "name" : if (item.get(2).equals(ruleValue)) res++; break;
                }
            }
            return res;
        }
    }
}
