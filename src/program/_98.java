package program;

public class _98 {
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
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);
    }
    public static class Solution {
        //记录上一个值，只要比他大即可
        int pre;
        //记录是否是有效的二叉树
        boolean flag = true;
        //记录是否是第一个节点
        boolean isFirst = true;
        public boolean isValidBST(TreeNode root) {
            dfs(root);
            return flag;
        }

        /**
         * 由于该树为搜索二叉树，所以采用中序遍历可以得到一个有序的序列
         * 只需要验证遍历的节点值是否升序即可
         */
        private void dfs(TreeNode root) {
            //剪枝，不用再遍历其它树了
            if(root == null || flag == false) return;
            dfs(root.left);
            //由于节点值卡边界为MaxInt/MinInt，所以需要一个新的变量判断是否是第一个值
            if(isFirst){
                isFirst = false;
                //如果为第一个节点则设置为pre
                pre = root.val;
            }else if(root.val <= pre){
                //由于是搜索二叉树，每个节点一定是从小到大有序且不能相等的
                flag = false;
            }
            //设置该节点为上一个节点
            pre = root.val;
            dfs(root.right);
        }
    }
}
