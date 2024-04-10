package program;

public class _1026 {
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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.maxAncestorDiff(root);
        System.out.println(res);
    }
    public static class Solution {
        int res = 0;
        public int maxAncestorDiff(TreeNode root) {
            //dfs(root, root.val, root.val);
            dfs(root);
            return res;
        }

        //方法1.递（先序遍历时，当前节点值同树中最大和最小值得到最大差值）
        private void dfs(TreeNode root, int mn, int mx) {
            if(root == null) return;
            mn = Math.min(root.val, mn); //获得当前树的最小值
            mx = Math.max(root.val, mx); //获得当前树的最大值
            res = Math.max(res, Math.max(root.val - mn, mx - root.val)); //获得当前树的最大差值
            dfs(root.left, mn, mx); //遍历左子树
            dfs(root.right, mn, mx); //遍历右子树
        }
        //方法2.归（后序遍历时，从叶节点不断往上返回最大值和最小值，在回溯的过程中和当前节点比较得到最大差值）
        private int[] dfs(TreeNode root){
            if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}; //到达叶子节点后为了不影响判断返回两个默认值
            int[] l = dfs(root.left); //返回左子树的最大值和最小值
            int[] r = dfs(root.right); //返回右子树的最大值和最小值
            int mn = Math.min(root.val, Math.min(l[0], r[0])); //将左右子树的最小值和当前值比较获得当前树的最小值
            int mx = Math.max(root.val, Math.max(l[1], r[1])); //将左右子树的最大值和当前值比较获得当前树的最大值
            res = Math.max(res, Math.max(mx - root.val, root.val - mn)); //将当前树的最大值和最小值同当前值比较获得当前树的最大差值
            return new int[]{mn, mx};
        }
    }
}
