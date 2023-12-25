package program;

public class _129 {
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
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.sumNumbers(root);
        System.out.println(res);
    }
    public static class Solution {
        int total = 0;
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
            // dfs_2(root, 0);
            // return total;
        }

        private int dfs(TreeNode root, int now) {
            if(root == null) return 0;
            //计算当前节点累加的值
            now = now*10 + root.val;
            //如果到达了叶子节点，则返回这个累加的值
            if(root.left == null && root.right == null) return now;
            //递归计算左右子树的累加值
            return dfs(root.left, now) + dfs(root.right, now);
        }

        //用一个变量记录累加值也行
        private void dfs_2(TreeNode root, int now) {
            if(root == null) return;
            //计算当前节点累加的值
            now = now*10 + root.val;
            //如果到达了叶子节点，则将此树的累加值放到total
            if(root.left == null && root.right == null) {
                total += now;
            }
            //递归计算左右子树的累加值
            dfs_2(root.left, now);
            dfs_2(root.right, now);
        }
    }
}
