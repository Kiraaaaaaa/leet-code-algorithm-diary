package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _103 {
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
        root.right.right = new TreeNode(5);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        List<List<Integer>> lists = solution.zigzagLevelOrder(root);
        System.out.println(lists);
    }
    public static class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            dfs(root, 0);
            for (int i = 0; i < lists.size(); i++) {
                // 翻转偶数层，因为插入时是从左到右，然而偶数层的遍历是从右到左
                if(i % 2 != 0) Collections.reverse(lists.get(i));
            }
            return lists;
        }
        private void dfs(TreeNode root, int level) {
            if(root == null) return;
            if(lists.size() == level) lists.add(new ArrayList<>());
            lists.get(level).add(root.val);
            dfs(root.left, level+1);
            dfs(root.right, level+1);
        }
    }
}
