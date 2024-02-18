package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _589 {
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
        List<Integer> list = solution.preorder_1(root);
        System.out.println(list);
    }
    public static class Solution {
        List<Integer> list = new ArrayList<>();
        //方法1.N叉树的先序遍历(DFS递归)
        public List<Integer> preorder(Node root) {
            dfs(root);
            return list;
        }
        private void dfs(Node root) {
            if(root == null) return;
            list.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i));
            }
        }
        //方法2.N叉树的先序遍历(DFS栈)
        public List<Integer> preorder_1(Node root) {
            if(root == null) return list;
            ArrayDeque<Node> stack = new ArrayDeque<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                Node pop = stack.pop();
                list.add(pop.val);
                //由于是先序遍历，所以孩子节点需要从右往左倒序入栈
                for (int i = pop.children.size() - 1; i >= 0; i--) stack.push(pop.children.get(i));
            }
            return list;
        }
    }
}
