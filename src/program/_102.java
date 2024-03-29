package program;

import java.util.*;

public class _102 {
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
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static class Solution {
        List<List<Integer>> list = new ArrayList<>(); //使用一个二维链表来存每一层的节点，另外再说下Arrays.asList()初始化的链表是不可修改的，否则使用get()、set()、add()的时候会报错UnsupportedOperationException
        public List<List<Integer>> levelOrder(TreeNode root){
            levelTree(root,0); //递归先序遍历
            return list;
        }
        //方法1.dfs递归
        private void levelTree(TreeNode root, int level) {
            if(root == null) return; //当前节点不存在就结束递归
            if(list.size() < level+1) list.add(new ArrayList<>()); //如果二维链表长度不够遍历的层则初始化子链表，否则list.get的时候会报错IndexOutOfBoundsException
            list.get(level).add(root.val); //往当前层所在的子链表添加数据，由于是先序遍历，所以顺序肯定是从左到右
            levelTree(root.left,level+1); //遍历左子树的同时传递该层的层级数，注意不要使用level++或者level--
            levelTree(root.right,level+1); //遍历右子树的同时传递该层的层级数，注意不要使用level++或者level--
        }
        //方法2.bfs使用队列
        private List<List<Integer>> levelTree_1(TreeNode root) {
            if(root == null) return list;
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while(!deque.isEmpty()){
                int size = deque.size(); //记录当前层的节点数
                list.add(new ArrayList<>()); //初始化当前层的子链表
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll(); //当前层的一个节点出队列
                    list.get(list.size()-1).add(poll.val); //将该节点的值添加到当前层的子链表中
                    if(poll.left != null) deque.add(poll.left); //如果当前节点有左子树，则入队列
                    if(poll.right != null) deque.add(poll.right); //如果当前节点有右子树，则入队列
                }
            }
            return list;
        }
    }
}
