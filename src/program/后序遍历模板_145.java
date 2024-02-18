package program;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 后序遍历模板_145 {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        List<Integer> list = solution.postorderTraversal_1(root);
        System.out.println(list);
    }
    public static class Solution {
        List<Integer> list = new ArrayList<>();
        //方法1.递归
        public List<Integer> postorderTraversal(TreeNode root) {
            dfs(root);
            return list;
        }
        public void dfs(TreeNode root){
            if(root==null) return;
            dfs(root.left);
            dfs(root.right);
            list.add(root.val);
        }
        //方法2.使用栈，迭代
        //个人整体思路：
        //1.只要该节点的左子树存在，则一直将左节点入栈
        //2.第一步结束后出栈最后一个节点，判断其右节点是否存在，如果存在，则将该右节点入栈
        //3.重复上述步骤
        //4.如果该节点是叶子节点，先将该节点值加入到结果中
        //5.判断该节点是否是父亲节点的右节点，如果是，则将父亲节点的右节点置空，同时该节点回溯到父亲节点
        //6.无论如何在回溯过程中都需要把左子树置空
        public List<Integer> postorderTraversal_1(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>(); //用来存储待遍历的节点
            while(root != null || !stack.isEmpty()){
                // 一、先遍历左子树
                while(root != null){ //如果root左子树存在，则优先将该节点左子树加入栈中
                    stack.push(root);
                    root = root.left;
                }
                // 二、开始回溯(出栈)
                root = stack.pop();
                if(root.left == null && root.right == null){ //是叶子节点
                    res.add(root.val); //先加到结果中
                    if(!stack.isEmpty()){ //如果栈不为空，说明还有节点需要遍历
                        if(stack.peek().right != null && root == stack.peek().right){ //如果当前节点是父节点的右节点
                            stack.peek().right = null; //则将父节点的右节点置空
                        }
                        root = stack.pop(); //将当前节点回溯到父节点
                        root.left = null; //将当前节点的左子树置空(回溯到父节点后，防止重复遍历左子树)
                    }else{ //如果栈为空了，说明是答案的最后一个节点了
                        root = null; //所有节点都遍历完了，结束
                    }
                }else if(root.right != null){ //如果root右节点存在，则将其加入栈中
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }
    }
}
