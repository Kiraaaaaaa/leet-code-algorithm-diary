package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _331 {
    public static void main(String[] args) {
        Solution so = new Solution();
        boolean res = so.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(res);
    }
    static class Solution {

        //方法1.将遍历的节点压入栈中，如果遇到两个连续的#，则弹出三个节点，压入一个#节点，直到栈顶元素只有一个#节点
        public boolean isValidSerialization(String preorder) {
            LinkedList<String> stack = new LinkedList<>();
            for (String s : preorder.split(",")) {
                stack.push(s);
                while(stack.size() >= 3
                        && stack.get(0).equals("#")
                        && stack.get(1).equals("#")
                        && !stack.get(2).equals("#")
                ){
                    for (int i = 0; i < 3; i++) stack.pop();
                    stack.push("#");
                }
            }
            return stack.size() == 1 && stack.get(0).equals("#");
        }
    }
}
