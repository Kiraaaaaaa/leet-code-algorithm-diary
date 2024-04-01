package program;

import java.util.HashMap;
import java.util.Map;

public class _105 {
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
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println();
    }
    public static class Solution {
        private Map<Integer, Integer> indexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = inorder.length;
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return mybuildTree(preorder, inorder, 0, n-1, 0, n-1);
        }
        public TreeNode mybuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
            if(preLeft > preRight) return null;
            Integer inRootIndex = indexMap.get(preorder[preLeft]);
            TreeNode root = new TreeNode(preorder[preLeft]); //构建根节点
            int size = inRootIndex - inLeft;
            //递归构建左子树
            root.left = mybuildTree(preorder, inorder, preLeft+1, preLeft+size, inLeft, inRootIndex-1);
            //递归构建右子树
            root.right = mybuildTree(preorder, inorder, preLeft+size+1, preRight, inRootIndex+1, inRight);
            return root;
        }
    }
}
