package program;

public class _230 {
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
        int res = solution.kthSmallest(root, 3);
        System.out.println(res);
    }
    public static class Solution {
        int count;
        int res;
        public int kthSmallest(TreeNode root, int k) {
            count = k;
            dfs(root);
            return res;
        }

        /**
         * 由于该树为搜索二叉树，所以采用中序遍历可以得到一个有序的序列
         * 由于遍历顺序是从小到大，所以根据给定的倒数最小值就可以得知是哪个节点，返回节点即可
         */
        private void dfs(TreeNode root) {
            //剪枝，不用再遍历其它树了
            if(root == null || count <= 0) return;
            dfs(root.left);
            //计数器为0，则说明找到
            if(--count == 0) res = root.val;
            dfs(root.right);
        }
    }
}
