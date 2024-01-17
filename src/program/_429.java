package program.template;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _429 {
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
        Node root = new Node(1, new ArrayList<>());
        root.children.add(new Node(3, new ArrayList<>()));
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));
        root.children.get(0).children.add(new Node(5, new ArrayList<>()));
        root.children.get(0).children.add(new Node(6, new ArrayList<>()));
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = buildTree();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }
    public static class Solution {
        //方法1.N叉树的层序遍历(BFS)
        public List<List<Integer>> levelOrder(Node root) {
            if(root == null) return new ArrayList<>();
            ArrayDeque<Node> deque = new ArrayDeque<>();
            List<List<Integer>> res = new ArrayList<>();
            deque.push(root);
            while(!deque.isEmpty()){
                int len = deque.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    Node node = deque.poll();
                    list.add(node.val);
                    for (int j = 0; j < node.children.size(); j++) {
                        deque.offer(node.children.get(j));
                    }
                }
                res.add(list);
            }
            return res;
        }
    }
}
