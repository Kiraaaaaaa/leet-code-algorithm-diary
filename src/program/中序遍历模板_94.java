package program;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 中序遍历模板_94 {
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
        List<Integer> list = solution.inorderTraversal_1(root);
        System.out.println(list);
    }
    public static class Solution {
        List<Integer> list = new ArrayList<>();
        //方法1.递归
        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }
        public void dfs(TreeNode root){
            if(root==null) return;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
        //方法2.使用栈，迭代
        public List<Integer> inorderTraversal_1(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>(); //用来存储待遍历的节点
            while(root != null || !stack.isEmpty()){
                //如果root左子树存在，则将左子树加入栈中
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                //开始出栈
                root = stack.pop();
                //根据出栈顺序，得到中序遍历结果
                res.add(root.val);
                //遍历该节点是否有右子树
                root = root.right;
            }
            return res;
        }
    }
}
