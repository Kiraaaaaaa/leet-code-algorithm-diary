package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class _2583 {
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
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        long res = solution.kthLargestLevelSum(root, 2);
        System.out.println(res);
    }
    public static class Solution {
        //思路：按照bfs标准模板遍历，记录每一层的和，然后排序，最后取第k大的值
        public long kthLargestLevelSum(TreeNode root, int k) {
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            ArrayList<Long> list = new ArrayList<>();
            deque.add(root);
            while(!deque.isEmpty()){
                int size = deque.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    sum += poll.val;
                    if(poll.left != null){
                        deque.add(poll.left);
                    }
                    if(poll.right != null){
                        deque.add(poll.right);
                    }
                }
                list.add(sum);
            }
            Collections.sort(list);
            return list.size() < k ? -1 : list.get(list.size()-k);
        }
    }
}
