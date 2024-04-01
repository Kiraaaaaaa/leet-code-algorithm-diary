package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2476 {
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
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);
        return root;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = buildTree();
        List<List<Integer>> lists = solution.closestNodes(root, List.of(2, 5, 16));
        System.out.println(lists);
    }
    public static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            dfs(root); //先保存数字到list中
            Collections.sort(list); //排个序，方便找min和max值
            /**
             * 查找方式1(超时)：遍历list，查找min和max值
             */
            for (Integer query : queries) {
                if(list.get(list.size()-1) < query){ //提前剪枝：先判断list中最大的值是否大于query的值，如果小于则直接设置min为最后一位值、max为-1
                    res.add(List.of(list.get(list.size()-1), -1));
                }else{
                    for (int i = 0; i < list.size(); i++) {
                        int num = list.get(i);
                        if(num == query){ //情况1.如果list中有值和query相等，则min和max都是该值
                            res.add(List.of(num, num));
                            break;
                        }
                        if(num > query){ //情况2.如果list中有值大于query，则min为该值的前一位，max为改值
                            res.add(List.of(i > 0 ? list.get(i-1) : -1, num));
                            break;
                        }
                    }
                }
            }
            /**
             * 查找方式2：二分查找
             */
            for (Integer query : queries) {
                int l = 0, r = list.size()-1;
                while(l <= r){ //第一步先遍历完list，查看是否有值等于query
                    int mid = (l + r) >> 1;
                    int num = list.get(mid);
                    if(num == query){ //情况1.如果list中该值和query相等，则min和max都是该值
                        res.add(List.of(num, num));
                        break;
                    }
                    else if (num < query) l = mid + 1; //情况2.如果list中该值小于query，则左指针右移到中点右边
                    else r = mid - 1; //情况3.如果list中该值大于query，则右指针左移到中点左边
                }
                if(l > r){ //第二步根据最后两个指针位置来判断是否存在min或者max值
                    if(l == list.size()) res.add(List.of(list.get(r), -1)); //情况1.所有值都比query小
                    else if(r == -1) res.add(List.of(-1, list.get(0))); //情况2.所有值都比query大
                    else res.add(List.of(list.get(r), list.get(l))); //情况3.存在min和max值
                }
            }
            return res;
        }
        private void dfs(TreeNode root) {
            if(root == null) return;
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
