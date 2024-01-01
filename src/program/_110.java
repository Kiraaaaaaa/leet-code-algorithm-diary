package program;

public class _110 {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        boolean res = solution.isBalanced(root);
        System.out.println(res);
    }
    public static class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            int heightDiff = Math.abs(dfs(root.left, 1) - dfs(root.right, 1));
            return heightDiff <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int dfs(TreeNode root, int level) {
            if(root == null) return level;
            return dfs(root.left, level+1) - dfs(root.right, level+1);
        }
    }
}
