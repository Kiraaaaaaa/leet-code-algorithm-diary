package 刷题;

import java.util.ArrayList;
import java.util.List;

public class _17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        List<String> strings = solution.letterCombinations("234");
        System.out.println(strings);
    }
    public static class Solution{
        //数字与字符串的映射，如果数字是2则对应该坐标下的abc
        String[] letter_map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if(digits==null||digits.length()==0){
                return new ArrayList<>();
            }
            //进行回溯
            //参数含义：数字组合、组合字符串、当前数字坐标
            dfs(digits, new StringBuffer(), 0);
            return res;
        }
        private void dfs(String str, StringBuffer letter, int index){
            //当前回溯终止条件：组合的字符串长度等于数字组合长度
            if(letter.length() == str.length()){
                //添加该结果到结果集
                res.add(letter.toString());
                return;
            }
            //取出当前数字
            char c = str.charAt(index);
            //得到数字映射的字母串准备遍历所有字符
            //由于得到的数字是字符，所以需要得到它的数字来作为坐标
            int pos = c -'0'-2; //c为'2'则拿到"abc"的坐标0
            String map_string = letter_map[pos];
            //遍历abc
            //接下来以abc组合def为例
            for (int i = 0; i < map_string.length(); i++) {
                //将该数字的该字母a存到当前数字中的字符串
                letter.append(map_string.charAt(i));
                //将已经组合字符串传给下一层继续拼接。到下一层的时，letter就为ad
                dfs(str, letter, index+1);
                /**
                 * 删除掉下一层产生的letter缓存
                 * 回溯的关键一点就在这里，对于每一种结果我们需要删除上一个结果产生的缓存信息
                 * 比如上一步我们dfs执行完后，letter字符串为ad，然后我们在开始特判时把letter存进去了
                 * 回溯到上一层的时候即现在，我们当前的字符为e，应该组合为ae，但是现在letter为ad
                 * 组合后就会变成ade，不仅组合方式会出问题，还会导致一个结果：
                 *
                 * 比如当前字符为e，组合后现在letter为ade
                 * 那么letter的长度就已经大于数字字符串的长度3>2
                 * 在34行str.charAt(index)就会产生字符串越界
                 * 所以必须要限制letter的长度不能大于数字字符串的长度
                 */
                letter.deleteCharAt(letter.length()-1);
            }
        }
    }
}
