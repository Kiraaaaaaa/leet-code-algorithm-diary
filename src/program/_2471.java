package program;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class _2471 {
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
        TreeNode root = new TreeNode(1,
                new TreeNode(4,
                        new TreeNode(7),
                        new TreeNode(6)),
                new TreeNode(3,
                        new TreeNode(8,
                                new TreeNode(9), null),
                        new TreeNode(5,
                                new TreeNode(10), null)));
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.minimumOperations(root);
        System.out.println(res);
    }
    public static class Solution {

        //方法1.BFS+置换环+离散化
        public int minimumOperations(TreeNode root) {
            int res = 0;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                int[] arr = new int[size], temp = new int[size]; // arr记录原数组，temp记录排序后数组
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    arr[i] = temp[i] = node.val;
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                Arrays.sort(temp);
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < size; i++) map.put(temp[i], i); // 离散化处理，记录排序后原数字的下标
                for (int i = 0; i < size; i++) { // 置换环，如果多个i位置的数字处于同一个环，while语句都不会执行，在第一次遇到新环后就已经循环排好序了
                    while(arr[i] != temp[i]){ // 直到置换后换数字与原数组相等，才算找到一个环，并排好序
                        Integer j = map.get(arr[i]);
                        int t = arr[i];
                        arr[i] = arr[j];
                        arr[j] = t;
                        res++; // 置换次数+1
                    }
                }
            }
            return res;
        }
    }
}
