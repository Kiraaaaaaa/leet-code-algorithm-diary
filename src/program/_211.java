package program;

import java.util.HashMap;
import java.util.Map;

public class _211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        boolean res1 = wordDictionary.search("pad");// 返回 False
        System.out.println(res1);
        boolean res2 = wordDictionary.search("bad");// 返回 True
        System.out.println(res2);
        boolean res3 = wordDictionary.search(".ad"); // 返回 True
        System.out.println(res3);

    }
    //字典树
    public static class WordDictionary {
        //记录该字母的下一位所有可能的字母坐标
        private WordDictionary[] children;
        //该字母是否为最后一个字母
        private boolean isEnd;
        public WordDictionary() {
            //初始化26个字母
            children = new WordDictionary[26];
            //默认为不是最后一个字母
            isEnd = false;
        }
        public void addWord(String word) {
            //得到字典树根节点
            WordDictionary node = this;
            //去遍历待插入单词的字符集合
            for (char c : word.toCharArray()) {
                //得到该字符在数组中的坐标
                int index = c - 'a';
                //如果正在遍历的该字母在上一个节点的数组坐标中没有记录，就新建一个字母节点在字典树中
                if(node.children[index] == null){
                    node.children[index] = new WordDictionary();
                }
                //每一次生成字母都移动指针到下一个字母节点
                node = node.children[index];
            }
            //最后一个字母节点设置为最后一个字母
            node.isEnd = true;
        }
        public boolean search(String word) {
            WordDictionary node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                //只要待检索的单词中包含'.'，则剩余部分都在dfs中进行递归判断
                if(c == '.'){
                    return dfs(node, word.substring(i));
                }
                //如果该字母不在字典树中，则说明不存在该单词，返回false
                if(node.children[index] == null){
                    return false;
                }
                //每一次生成字母都移动指针到下一个字母节点
                node = node.children[index];
            }
            return node.isEnd;
        }

        //参数：1.单词中当前位置的字母节点，2.包含当前字母的剩余字符串
        private boolean dfs(WordDictionary node, String word) {
            //开始遍历剩余的字符串
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if(c == '.'){
                    //对于当前的字母，定义一个结果，默认为没有找到
                    boolean find = false;
                    //如果当前字母为'.'，则遍历当前节点的所有子节点
                    for (int j = 0; j < node.children.length; j++) {
                        //如果有可用的子节点，则开始递归遍历子节点中所有字母
                        if(node.children[j] != null){
                            //准备递归遍历这些子节点，(重点)如果找到了其中一种可行性，则返回true，'|='代表只要有一种方案可行就是true
                            find |= dfs(node.children[j], word.substring(i+1));
                        }
                    }
                    //返回当前的调查结果
                    return find;
                }
                //如果当前字母不在字典树中，则返回false
                if(node.children[index] == null){
                    return false;
                }
                node = node.children[index];
            }
            return node.isEnd;
        }
    }
}
