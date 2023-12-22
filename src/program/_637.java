package program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class _637 {
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
        List<Double> doubles = solution.averageOfLevels(root);
        System.out.println(doubles);
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
        List<List<Double>> list = new ArrayList<>();
        public List<Double> averageOfLevels(TreeNode root) {
            //先保存每一层的值
            dfs(root, 0);
            //再计算平均值，使用stream流
            List<Double> res = list.stream().map(arr -> arr.stream().mapToDouble(Double::doubleValue).average().getAsDouble()).collect(Collectors.toList());
            return res;
        }

        private void dfs(TreeNode root, int i) {
            if(root == null) return;
            //如果是第一次遍历到当前层，则list新增一个当前层的列表准备保存当前层的值
            if(list.size() == i){
                list.add(new ArrayList<>());
            }
            //保存当前层的值
            list.get(i).add((double) root.val);
            dfs(root.left, i+1);
            dfs(root.right, i+1);
        }
    }
}
