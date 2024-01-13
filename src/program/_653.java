package program;

import java.util.ArrayDeque;
import java.util.HashSet;

public class _653 {
    // 二叉树节点
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //构造二叉树结构
    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        boolean res = solution.findTarget_1(root, 9);
        System.out.println(res);
    }
    public static class Solution {
        HashSet<Integer> set = new HashSet<>();
        //方法1.深度优先遍历DFS(前序遍历)+哈希表
        public boolean findTarget(TreeNode root, int k) {
            if(root == null) return false;
            if(set.contains(k-root.val)) return true;
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
        //方法2.广度优先遍历BFS+哈希表
        public boolean findTarget_1(TreeNode root, int k) {
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while(!deque.isEmpty()){
                TreeNode node = deque.poll();
                if(set.contains(k-node.val)) return true;
                set.add(node.val);
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
            return false;
        }
    }
}
