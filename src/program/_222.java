package program;

public class _222 {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.countNodes(root);
        System.out.println(res);
    }
    public static class Solution {
        int res = 0;
        public int countNodes(TreeNode root) {
            return dfs_2(root);
        }

        //外部变量解法
        private void dfs_1(TreeNode root) {
            if(root == null) return;
            res++;
            dfs_1(root.left);
            dfs_1(root.right);
        }
        // 递归，但是同时每次遍历返回计数
        private int dfs_2(TreeNode root){
            if(root == null) return 0;
            return dfs_2(root.left) + dfs_2(root.right) + 1;
        }
        // 进阶，利用完全二叉树的性质解题，涉及数学，难度算中等及以上了，不写了
    }
}
