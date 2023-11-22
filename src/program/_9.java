package program;

import java.util.HashMap;
import java.util.Set;

public class _9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        boolean b = solution.isIsomorphic("ba", "bb");
        System.out.println(b);
    }

    /**
     * 映射关系只有一种啊，首先注意：a作为key，b作为value，和反过来是完全不同的两种映射。
     * 这是对应的：bbbaaa=aaabbb，但是bbbaaab!=aaabbbb，因为b作为key首先就和a建立关系了，后面b还来作为key和b建立映射肯定不对啊。
     * 而且，题中说的同一个字符和自己本身可以作为映射，人家意思是说c可以作为key和c作为value建立映射，并不意味着ccc=cdd，
     * 其实就是相当于这句话说了和没说一样，反而会误导一些人。
     * a可以作为key绑定b，b也可以作为key绑定c，这是没问题的，但key和value是一对一绝对绑定的。
     */
    public static class Solution{
        public boolean isIsomorphic(String aString, String bString) {
            HashMap<Character, Character> map = new HashMap();
            int cur = 0, end = aString.length()-1;
            while(cur <= end){
                Character skey = map.get(aString.charAt(cur));
                //有映射
                if(skey != null){
                    //映射如果不对应
                    if(bString.charAt(cur)!=map.get(aString.charAt(cur))){
                        return false;
                    }
                }else{
                    //没有映射，需要判断t中的该字符是否已经被映射过了
                    Character sValue = bString.charAt(cur);
                    Set<Character> keys = map.keySet();
                    for (Character key : keys) {
                        //如果t中的该字符已经被s中的某字符映射过了则返回false
                        if(map.get(key) == bString.charAt(cur)){
                            return false;
                        }
                    }
                    //没有映射就添加进s和t之间的映射
                    map.put(aString.charAt(cur), sValue);
                }
                cur++;
            }
            return true;
        }
    }
}
