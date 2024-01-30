package program;

import java.util.HashSet;
import java.util.Set;

public class _671 {
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        int res = solution.findSecondMinimumValue_1(root);
        System.out.println(res);
    }
    public static class Solution {
        //方法1.遍历树，收集所有数后去重逐个比较
        Set<Integer> set = new HashSet<>();
        public int findSecondMinimumValue(TreeNode root) {
            dfs(root);
            if(set.size() < 2) return -1;
            int min = Integer.MAX_VALUE, second_Min = Integer.MAX_VALUE; //第一小，第二小值
            for (Integer integer : set) {
                if(integer < min){ //如果当前值比最小值小
                    second_Min = min; //最小值变成第二小值
                    min = integer; //当前值变成最小值
                }else if(integer < second_Min){ //如果当前值比第二小值小
                    second_Min = integer; //第二小值变成当前值
                }
            }
            return second_Min;
        }
        private void dfs(TreeNode root) {
            if(root == null) return;
            set.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }

        //方法2.在遍历树时，直接进行比较
        int ans = -1;
        public int findSecondMinimumValue_1(TreeNode root) {
            dfs(root, root.val);
            return ans;
        }
        void dfs(TreeNode root, int cur) {
            if (root == null) return ;
            if (root.val != cur) {
                if (ans == -1) ans = root.val;
                else ans = Math.min(ans, root.val);
                return ;
            }
            dfs(root.left, cur);
            dfs(root.right, cur);
        }
    }
}
