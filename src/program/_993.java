package program;

import java.util.ArrayDeque;

public class _993 {
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
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        boolean res = solution.isCousins(root, 4, 3);
        System.out.println(res);
    }
    public static class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            //BFS
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            boolean findX = false;
            boolean findY = false;
            while(!queue.isEmpty()){
                int size = queue.size();

                while(size-- > 0){
                    TreeNode node = queue.poll();
                    //如果左右节点都存在，并且值分别等于x和y，返回false（相当于这x和y节点拥有同一个父节点，所以直接返回false）
                    if((node.left != null && node.right != null) && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))){
                        return false;
                    }
                    if(node.left != null){ //如果存在左节点，入队列
                        queue.offer(node.left);
                    }
                    if(node.right != null){ //如果存在右节点，入队列
                        queue.offer(node.right);
                    }
                    if(node.val == x){ //如果找到x节点，标记为true
                        findX = true;
                    }
                    if(node.val == y){ //如果找到y节点，标记为true
                        findY = true;
                    }
                    if(findX && findY){ //如果x和y都找到，说明在同一层中，且不是同一个父节点，返回true
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
