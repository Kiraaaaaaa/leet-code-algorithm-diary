package program;

import java.util.HashMap;
import java.util.Map;

public class _2385 {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.amountOfTime(root, 3);
        System.out.println(res);
    }
    public static class Solution {

        private TreeNode startNode;
        private final Map<TreeNode, TreeNode> fa = new HashMap<>();

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, null, start);
            return maxDepth(startNode, startNode);
        }

        private void dfs(TreeNode node, TreeNode from, int start) {
            if (node == null) {
                return;
            }
            fa.put(node, from); // 记录每个节点的父节点
            if (node.val == start) {
                startNode = node; // 找到 start
            }
            dfs(node.left, node, start);
            dfs(node.right, node, start);
        }

        private int maxDepth(TreeNode node, TreeNode from) {
            if (node == null) {
                return -1; // 注意这里是 -1，因为 start 的深度为 0
            }
            int res = -1;
            if (node.left != from) {
                res = Math.max(res, maxDepth(node.left, node));
            }
            if (node.right != from) {
                res = Math.max(res, maxDepth(node.right, node));
            }
            if (fa.get(node) != from) {
                res = Math.max(res, maxDepth(fa.get(node), node));
            }
            return res + 1;
        }
    }

}
