package program.template;

import java.util.List;

public class _1379 {
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
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        TreeNode res = solution.getTargetCopy(root, root, new TreeNode(3));
        System.out.println(res.val);
    }
    static class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if(cloned == null) return null;
            if(cloned.val == target.val) return cloned;
            TreeNode l = getTargetCopy(original, cloned.left, target);
            TreeNode r = getTargetCopy(original, cloned.right, target);
            return l == null ? r : l;
        }
    }
}
