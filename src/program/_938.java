package program;

public class _938 {
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.rangeSumBST(root, 7, 15);
        System.out.println(res);
    }
    public static class Solution {
        int res = 0;
        boolean flag = false; //其实不需要用到flag，直接判断root.val是否在范围内即可
        public int rangeSumBST(TreeNode root, int low, int high) {
            dfs(root, low, high);
            return res;
        }
        private void dfs(TreeNode root, int low, int high) {
            if(root == null) return;
            dfs(root.left, low, high);
            if(root.val == low || root.val == high) flag = !flag;
            if(flag || root.val == high) res += root.val;
            dfs(root.right, low, high);
        }
    }
}
