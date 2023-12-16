package test;

import java.util.Arrays;

public class 圣诞树 {
    /**
     * 打印圣诞树
     * @param args
     */
    public static void main(String[] args) {
        int height = 6, nowLevel = 1;
        buildChristmasTree(height, nowLevel);
    }
    //递归构建层级
    private static void buildChristmasTree(int height, int nowLevel) {
        if(nowLevel > height) return;
        buildPrefix(height-nowLevel, 1);
        buildContent(nowLevel * 2 - 1, 1);
        buildChristmasTree(height, ++nowLevel);
    }
    //递归构建空白
    private static void buildPrefix(int prefixLen, int nowPrefixLen) {
        if(nowPrefixLen > prefixLen) return;
        System.out.print(nowPrefixLen == prefixLen ? " " : " ");
        buildPrefix(prefixLen, ++nowPrefixLen);
    }
    //递归构建主体
    private static void buildContent(int contentLen, int nowIndex) {
        if(nowIndex > contentLen) return;
        System.out.print(nowIndex % 2 == 0 ? nowIndex == contentLen ? "_\n" : "_" : nowIndex == contentLen ? "*\n" : "*");
        buildContent(contentLen, ++nowIndex);
    }
}
