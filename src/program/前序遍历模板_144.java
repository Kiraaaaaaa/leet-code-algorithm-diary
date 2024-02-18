package program;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 前序遍历模板_144 {
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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        List<Integer> list = solution.preorderTraversal_1(root);
        System.out.println(list);
    }
    public static class Solution {
        List<Integer> list = new ArrayList<>();
        //方法1.递归
        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }
        public void dfs(TreeNode root){
            if(root==null) return;
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
        //方法2.使用栈，迭代
        public List<Integer> preorderTraversal_1(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>(); //用来存储待遍历的节点
            while(root != null || !stack.isEmpty()){
                while(root != null){ //先把左子树全部节点依次放入栈中
                    stack.push(root);
                    res.add(root.val);
                    root = root.left;
                }
                TreeNode node = stack.poll(); //得到当前子树的最后一个节点node
                root = node.right; //存放node节点的右子树，准备遍历右节点
            }
            return res;
        }
    }
}
