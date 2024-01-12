package program;

public class _543 {
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
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.diameterOfBinaryTree(root);
        System.out.println(res);
    }
    public static class Solution {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            dfs(root);
            return ans - 1;
        }

        private int dfs(TreeNode root) {
            if(root == null) return 0;
            int L = dfs(root.left); //计算当前子树的左子树最高度
            int R = dfs(root.right); //计算当前子树的右子树最高度
            ans = Math.max(ans, L+R+1); //更新最大高度
            return Math.max(L, R) + 1; //返回当前子树的最高度
        }
    }
}
