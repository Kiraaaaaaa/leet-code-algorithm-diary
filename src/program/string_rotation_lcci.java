package program;

import java.util.ArrayList;

public class string_rotation_lcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean flipedString = solution.isFlipedString("waterbottle", "erbottlewat");
        System.out.println(flipedString);
    }
    public static class Solution{
        public boolean isFlipedString(String s1, String s2) {
            return s1.length()!=s2.length()?false:(s2+s2).contains(s1)?true:false;
        }
    }
}
