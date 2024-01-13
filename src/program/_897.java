package program;

public class _897 {
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
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        TreeNode head = solution.increasingBST(root);
        while(head!=null){
            System.out.print(head.val + "->");
            head = head.right;
        }
    }
    public static class Solution {
        TreeNode resNode; //定义一个新节点，用于构建新二叉树
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyNode = new TreeNode(-1); //定义一个虚拟头节点，用于连接新二叉树
            resNode = dummyNode;
            inorder(root); //开始中序遍历
            return dummyNode.right; //返回虚拟头节点的右节点
        }
        public void inorder(TreeNode node) {
            if(node == null) return;
            inorder(node.left); //先遍历左子树
            node.left = null; //先让node的左节点为空，使其生成的新二叉树只包含右子树
            resNode.right = node; //新二叉树的右节点指向当前节点
            resNode = node; //新二叉树的节点指向当前节点
            inorder(node.right); //再遍历右子树
        }
    }
}
