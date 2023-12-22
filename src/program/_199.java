package program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199 {
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
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        List<Integer> list = solution.rightSideView_dfs(root);
        System.out.println(list);
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    public static class Solution {
        List<Integer> list = new ArrayList<>();
        //DFS解法，先遍历右子树，再遍历左子树，根据递归的层数来保存当前层数的最右边节点
        public List<Integer> rightSideView_dfs(TreeNode root){
            levelTree(root, 0);
            return list;
        }
        private void levelTree(TreeNode root, int level) {
            if(root == null) return;
            if(list.size() <= level){
                list.add(root.val);
            }
            levelTree(root.right, level+1);
            levelTree(root.left, level+1);
        }
        //BFS解法，将当前节点保存到队列中，然后将左子节点或者右子节点保存到队列中，根据队列长度，在队列最后一位时把当前层节点值保存到链表中，直到队列为空
        public List<Integer> rightSideView_bfs(TreeNode root){
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            //声明一个队列保存当前的节点
            Queue<TreeNode> queue = new LinkedList<>();
            //将头节点放入队列中
            queue.offer(root);
            //只要队列不为空，就代表广度优先遍历还没有结束，还有未知节点
            while(queue.size() > 0){
                //需要实现声明队列长度，因为队列的长度在遍历当前节点并添加子节点到队列是动态的，如果不事先声明我们无法得知当前层的最后一个元素是在哪个位置，会造成预期之外的错误
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    //取出当前层的当前节点
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        //队列保存此节点的左子节点
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        //队列保存此节点的右子节点
                        queue.offer(node.right);
                    }
                    //如果遍历到了当前层的最后一个节点，就将当前层的此节点值保存到链表中
                    if(i == size-1){
                        list.add(node.val);
                    }
                }
                //已经结束了当前层节点的遍历，并已经将当前层的所有子节点保存到了队列中，开始下一层节点的遍历
            }
            return list;
        }
    }
}
