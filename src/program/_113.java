package program;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _113 {

    static class TreeNode {
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
        TreeNode treeNode = new TreeNode();
        /**
         * 链表测试数据懒得加了
         */
        Solution solution = new Solution();
        solution.pathSum(treeNode, 22);
    }
    public static class Solution {
        //答案数组
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        //当前正在计算的路径(从根节点开始)
        Deque<Integer> path = new LinkedList<Integer>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum);
            return ret;
        }
        public void dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            //将当前节点值存入当前路径
            path.offerLast(root.val);
            // 也可以先减去root.val的值，但是下方要判断targetSum == 0，目的就是比较到达叶子节点后总路径值是否等于目标值
            // targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == root.val) {
                //已到达叶子节点，当前可行路径存入结果集
                //采用深拷贝的方式，否则path一旦改变结果集的数组也将改变
                ret.add(new LinkedList<Integer>(path));
            }
            //继续递归左子树
            dfs(root.left, targetSum - root.val);
            //继续递归右子树
            dfs(root.right, targetSum - root.val);
            //必须等到某子树的某两边的子树都递归完了才删除节点，不能切换顺序，如果左子树先pollLast了，如果还有右子树没有遍历，那么就会导致path路径断开
            path.pollLast();
        }
    }
}
