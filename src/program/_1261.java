package program;

import java.util.HashSet;

public class _1261 {
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
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = buildTree();
        FindElements fe = new FindElements(root);
        System.out.println(root.left.right.val);
    }
    public static class FindElements {
        HashSet<Integer> set = new HashSet<>();
        public FindElements(TreeNode root) {
            dfs(root, 0);
        }

        private void dfs(TreeNode root, int val) {
            if(root == null) return;
            root.val = val;
            set.add(root.val);
            dfs(root.left, 2*val+1);
            dfs(root.right, 2*val+2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
