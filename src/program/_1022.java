package program;

public class _1022 {
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
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.sumRootToLeaf(root);
        System.out.println(res);
    }
    public static class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }
        private int dfs(TreeNode root, int sum) {
            if(root == null) return 0;
            sum = (sum << 1) + root.val; //该道路之前的累加值左移一位，加上当前节点的值获得最新累加值
            if(root.left == null && root.right == null) return sum; //到达叶子节点，返回该道路累加值
            return dfs(root.left, sum) + dfs(root.right, sum); //递归遍历左子树和右子树，将左子树的累加值和右子树的累加值汇总
        }
    }
}
