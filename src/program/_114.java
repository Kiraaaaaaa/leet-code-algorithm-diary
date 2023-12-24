package program;

public class _114 {
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
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        solution.flatten_1(root);
        TreeNode cur = root;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
    public static class Solution {
        /**
         * 自顶向下方式，先将右子树嫁接到左子树的最右节点上
         * 然后将嫁接后的树作为当前节点的右子树
         * 清空左子树
         * 以上步骤不断循环，从上到下第一个节点开始，是一个先总体、后局部的嫁接
         * @param root
         */
        public void flatten_1(TreeNode root) {
            while(root != null){
                //如果该节点没有左子节点就继续移动到下一个节点
                if(root.left == null){
                    root = root.right;
                }
                //如果该节点有左子节点了，就找该左子节点下的最右边一个节点
                else{
                    //获取该左子节点
                    TreeNode pre = root.left;
                    //如果该左子节点有其右子节点，则一直找下去
                    while(pre.right != null){
                        pre = pre.right;
                    }
                    //如果该左子节点没有最右子节点，则pre以该左子节点为准

                    //将该节点的所有右子树暂时嫁接到左子节点的右子树上
                    pre.right = root.right;
                    //将该节点的右子树替换为【该节点的左子树嫁接该节点的右子树后的新树】
                    root.right = root.left;
                    //清空该节点的左子树
                    root.left = null;

                    //开始下一个节点
                    root = root.right;
                }
            }
        }
    }
}
