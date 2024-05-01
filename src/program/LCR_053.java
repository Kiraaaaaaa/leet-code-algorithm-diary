package program;

public class LCR_053 {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        TreeNode treeNode = solution.inorderSuccessor(root, root.left);
        System.out.println(treeNode.val);
    }
    public static class Solution {
        //方法1.采用dfs中序遍历，如果找到第一个大于p节点的节点则返回该节点
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            return dfs(root, p);
        }
        private TreeNode dfs(TreeNode root, TreeNode p) {
            if(root == null) return null;
            TreeNode node1 = dfs(root.left, p);
            if(root.val > p.val && node1 == null) return root;
            TreeNode node2 = dfs(root.right, p);
            return node1 != null ? node1 : node2;
        }
    }
}
