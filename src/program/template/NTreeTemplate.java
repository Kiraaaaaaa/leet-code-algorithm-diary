package program.template;

import java.util.List;

public class NTreeTemplate {
    // N叉树节点
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    //构造N叉树结构
    private static Node buildTree() {
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = buildTree();
        solution.method(root);
        System.out.println();
    }
    public static class Solution {
        public void method(Node root) {

        }
    }
}
