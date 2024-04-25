package program;

public class _437 {
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
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(-2);

        //只有右节点测试用例
        // TreeNode root = new TreeNode(1);
        // root.right = new TreeNode(2);
        // root.right.right = new TreeNode(3);
        // root.right.right.right = new TreeNode(4);
        // root.right.right.right.right = new TreeNode(5);
        return root;
    }
    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        TreeNode root = buildTree();
        int res = solution.pathSum(root, 3);
        System.out.println(res);
    }

    //自己的shit代码，还有问题，卡在100用例
    public static class Solution {
        int res = 0;
        public int pathSum(TreeNode root, int targetSum) {
            if(root == null) return 0;
            dfs(root, root.val, targetSum); //参数：选取节点，祖先节点值包括自身的和或者只包含自身的值，目标和
            return res;
        }
        private void dfs(TreeNode root, int i, int targetSum) {
            System.out.println(i);
            if(i == targetSum) res++;
            if(root == null) return;
            if(root.left != null){
                dfs(root.left, root.left.val, targetSum); //只包含自身值的递归
                dfs(root.left, root.left.val + i, targetSum); //包含祖先和自身值的递归
            }
            if(root.right != null){
                dfs(root.right, root.right.val, targetSum); //只包含自身值的递归
                dfs(root.right, root.right.val + i, targetSum); //包含祖先和自身值的递归
            }
        }
    }
    //把每一个节点都当做根节点，往下求和
    public static class Solution_1 {
        int res = 0;
        public int pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return res;
        }
        private void dfs(TreeNode root, int targetSum) {
            if(root == null) return;
            dfs_sum(root, targetSum, root.val); //将每一个节点都当做根节点，累加其路径上的值
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
        }

        private void dfs_sum(TreeNode root, int targetSum, long i) {
            if(i == targetSum) res++;
            if(root.left != null) dfs_sum(root.left, targetSum, root.left.val + i);
            if(root.right != null) dfs_sum(root.right, targetSum, root.right.val + i);
        }
    }
}
