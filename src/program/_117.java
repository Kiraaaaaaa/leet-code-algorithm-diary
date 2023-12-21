package program;

import java.util.ArrayList;
import java.util.List;

public class _117 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = buildTree();
        Node node = solution.connect(root);
        System.out.println(node);
    }

    private static Node buildTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        return root;
    }
    public static class Solution {
        public Node connect(Node root) {
            if(root == null){
                return null;
            }
            //对当前访问层的第一个节点进行操作，此过程中这里的cur分别为[1,2,4]
            Node cur = root;
            while(cur != null){
                //dummy节点是用于访问下一层的入口，仅作为一个入口方便从头开始遍历下一层，是固定位置且无值的
                Node dummy = new Node();
                //使用pre节点作为待连接下一层的节点，会在连接过程中不断移动，相当于一个指针
                Node pre = dummy;
                //通过当前节点的next遍历当前层的节点
                while(cur != null){
                    //如果当前节点存在左子节点，则将该左子节点连接到下一层的链表中
                    if(cur.left != null){
                        pre.next = cur.left;
                        pre = pre.next; //用于连接链表的指针右移
                    }
                    //如果当前节点存在右子节点，则将该右子节点连接到下一层的链表中
                    if(cur.right != null){
                        pre.next = cur.right;
                        pre = pre.next; //用于连接链表的指针右移
                    }
                    //当前节点的左右子节点已经连接到下一层的链表中了，继续访问当前层的下一个节点，继续连接其子节点到下一层的链表中
                    cur = cur.next;
                }
                //下一层的链表已经连接完毕
                //将下一层的入口作为第一个节点，继续循环下一层，如果cur为空，代表所有层数已经访问完毕
                cur = dummy.next;
            }
            return root;
        }
    }
}
