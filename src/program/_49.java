package program;

import java.util.*;
import java.util.stream.Collectors;

public class _49 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        List<List<String>> lists = solution.groupAnagrams_3(strs);
        System.out.println(lists);

    }
    public static class Solution {
        /**
         * 方法一：将字符串中的各字符的ASCII码相加转换为哈希值，然后将哈希值作为key，将字符串作为value，保存到map中
         * 但是有个bug，如果字符串中的字符不一样但是ASCII码相加一样，那么会被分到同一个集合中
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams_1(String[] strs) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int strHash = 0;
                for (int i = 0; i < str.length(); i++) {
                    //将每一位的ASCII码相加，得到一个哈希值，以此值作为key
                    strHash += str.charAt(i);
                }
                //如果该类型字符串不存在，则创建该类型字符串的集合保存到map中
                if(!map.containsKey(strHash)){
                    map.put(strHash, new ArrayList<String>(){{add(str);}});
                }else{
                    //如果该类型字符串存在，则保存该字符串到该类型字符串的集合中
                    map.get(strHash).add(str);
                }
            }
            //使用stream流将map中的值转化为集合，最后返回结果
            List<List<String>> res = map.entrySet().stream().map(entry -> entry.getValue().stream().collect(Collectors.toList())).collect(Collectors.toList());
            return res;
        }

        /**
         * 方法1换个思路，将每个字符串的字符集合排序，就能得到一个唯一的字符串，然后将该排序的字符串作为key，将字符串作为value，保存到map中
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams_3(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String strHash = new String(chars);
                //如果该类型字符串不存在，则创建该类型字符串的集合保存到map中
                if(!map.containsKey(strHash)){
                    map.put(strHash, new ArrayList<String>(){{add(str);}});
                }else{
                    //如果该类型字符串存在，则保存该字符串到该类型字符串的集合中
                    map.get(strHash).add(str);
                }
            }
            //使用stream流将map中的值转化为集合，最后返回结果
            List<List<String>> res = map.entrySet().stream().map(entry -> entry.getValue().stream().collect(Collectors.toList())).collect(Collectors.toList());
            return res;
        }

        /**
         * 方法二：使用stream流进行分组，然后将分组后的结果转化为集合，最后返回结果
         * 其中chars()方法返回一个迭代器，迭代器中包含了字符串中每个字符的ASCII码
         * 对该迭代器进行排序，然后将排序后的字符转换为字符串，最后将字符串作为key，将字符串数组作为value，保存到map中
         * 其中appendCodePoint()方法将字符转换为Unicode码，然后将Unicode码添加到StringBuilder中，append()方法将StringBuilder中的字符构建为一个新的字符串
         * 注意：虽然StringBuilder::append可以用来构建新的字符串，但为了获得一个不可变的字符串，需要使用toString()方法将StringBuilder对象转换为不可变的字符串
         * 然后使用stream流将map中的值使用values()转化为集合，最后返回结果
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams_2(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());
        }
    }
}
