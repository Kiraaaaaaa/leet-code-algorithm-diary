package program;

import java.util.Random;

public class _108 {
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
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();
    }
    public static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return tree_2(nums, 0, nums.length-1);
        }

        // 递归构建二叉树方法1
        private TreeNode tree_1(int[] nums, int left, int right) {
            if(left > right) return null;
            //取数组区间的中点坐标，还有两种符合题意的计算方式：
            //方式1: int mid = (left+right+1)/2 以中点坐标偏右一位为中点
            //方式2: int mid = (left+right+new Random().nextInt(2))/2 以其中一个随机数为中点
            int mid = (left+right)/2; //以中点坐标偏左一位为中点
            //以当前中点作为根节点
            TreeNode root = new TreeNode(nums[mid]);
            //递归构建当前节点左边的数组作为左子树
            root.left = tree_1(nums, left, mid - 1);
            //递归构建当前节点右边的数组作为右子树
            root.right = tree_1(nums, mid+1, right);
            return root;
        }

        // 递归构建二叉树方法2，一行代码实现更简洁
        private TreeNode tree_2(int[] nums, int left, int right) {
            return left > right ? null : new TreeNode(nums[(left+right)/2], tree_2(nums, left, (left+right)/2-1), tree_2(nums, (left+right)/2, right));
        }
    }
}
