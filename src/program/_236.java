package program;

public class _236 {
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
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode treeNode = solution.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(treeNode.val);
    }
    public static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 只要当前节点为p或者q就返回该值
            if(root == null || p == root || q == root) return root;
            // 递归左子节点，返回值记为left
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 递归右子节点，返回值记为right
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null && right == null) return null;
            //如果左子树结果为空，则返回右子树的结果，这里可以视为向上报告。如果p和q在同一路径下(也就是p是q的祖先，或q是p的祖先)，则会被更上面的所替代。
            if(left == null) return right;
            //如果右子树结果为空，则返回左子树的结果，这里可以视为向上报告。如果p和q在同一路径下(也就是p是q的祖先，或q是p的祖先)，则会被更上面的所替代。
            if(right == null) return left;
            //如果以上情况都不是，则是该节点左右两边都有返回值，代表当前节点为最近公共祖先，返回该节点即可
            return root;
        }
    }
}
