package program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _987 {
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
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        List<List<Integer>> lists = solution.verticalTraversal(root);
        System.out.println(lists);
    }
    public static class Solution {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
            if(a[0] != b[0]) return a[0] - b[0]; //列的排序优先级最高
            if(a[1] != b[1]) return a[1] - b[1]; //行的排序优先级次之
            return a[2] - b[2]; //值的排序优先级最低
        });
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            int[] node = new int[]{0, 0, root.val}; //列，行，值
            queue.add(node);
            dfs(root, node);
            List<List<Integer>> ans = new ArrayList<>();
            while(!queue.isEmpty()){
                int[] info = queue.poll();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(info[2]);
                while(!queue.isEmpty() && queue.peek()[0] == info[0]) list.add(queue.poll()[2]); //如果两节点列相同，将值加入所属的list
                ans.add(list);
            }
            return ans;
        }
        private void dfs(TreeNode root, int[] node) {
            if(root.left != null){
                int[] info = new int[]{node[0]-1, node[1]+1, root.left.val}; //如果左节点存在，则将(列-1，行+1，值)加入队列
                queue.add(info);
                dfs(root.left, info);
            }
            if(root.right != null){
                int[] info = new int[]{node[0]+1, node[1]+1, root.right.val}; //如果右节点存在，则将(列+1，行+1，值)加入队列
                queue.add(info);
                dfs(root.right, info);
            }
        }
    }
}
