package program;

public class _235 {
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
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        solution.lowestCommonAncestor(root, p, q);
        System.out.println();
    }
    public static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int x = root.val;
            if(x > p.val && x > q.val){
                return lowestCommonAncestor(root.left, p, q);
            }
            if(x < p.val && x < q.val){
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
