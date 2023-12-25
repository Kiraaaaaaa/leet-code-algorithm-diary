package program;

public class _530 {
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int min = solution.getMinimumDifference(root);
        System.out.println(min);
    }
    public static class Solution {
        int ans = Integer.MAX_VALUE;
        //上一个节点的值
        int pre = -1;
        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return ans;
        }

        /**
         * 由于该树为搜索二叉树，所以采用中序遍历可以得到一个有序的序列
         * 计算每个序列间的差值则可以找到最小差值
         */
        private void dfs(TreeNode root) {
            if(root == null) return;
            dfs(root.left);
            //如果是第一个节点，则设置第一个节点值为pre
            if(pre == -1){
                pre = root.val;
            }else{
                //否则，计算当前节点与前一个节点的差值，并更新最小差值
                ans = Math.min(ans, root.val-pre);
                //更新当前节点的值为pre
                pre = root.val;
            }
            dfs(root.right);
        }
    }
}
