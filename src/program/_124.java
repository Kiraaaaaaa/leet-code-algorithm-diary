package program;

public class _124 {
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
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.maxPathSum(root);
        System.out.println(res);
    }

    //方法1.后续遍历（求路径和一般都是后序遍历）
    public static class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }
        private int dfs(TreeNode root) {
            if(root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            int sum = root.val + left + right;//得到当前左子树+右子树+该节点的路径和
            max = Math.max(max, sum); //判断当前节点作为根节点的最大路径和是否是最长的
            int road_sum = root.val + Math.max(left, right); //由于路径是一条线，所以只能加左子树或者右子树其一
            return road_sum < 0 ? 0 : road_sum; // 当前二叉树的最长路径返回给上级节点
        }
    }
}
