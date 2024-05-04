package program;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kth_node_from_end_of_list_lcci {
    // 链表节点
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //构造链表结构
    private static ListNode buildList() {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        for (int i = 0; i < 5; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        int head = solution.kthToLast_3(root.next, 2);
        System.out.println(head);
    }
    public static class Solution {
        int count = 0; // 记录链表倒数长度
        int res; // 结果
        //解法1.递归
        public int kthToLast(ListNode head, int k) {
            dfs(head, k);
            return res;
        }
        private void dfs(ListNode head, int k) {
            if(head == null) return;
            dfs(head.next, k);
            count++;
            if(count == k) res = head.val;
        }
        //解法2.快慢指针
        public int kthToLast_1(ListNode head, int k) {
            ListNode fast = head, slow = head;
            // 快指针先走k步
            while(fast != null && k > 0){
                fast = fast.next;
                --k;
            }
            // 两个指针同步走，当快指针走完链表时，slow指向的节点就是倒数第k个节点
            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            return slow.val;
        }

        //下面的纯暴力，都没意思

        //方法3.list按顺序存储所有节点
        public int kthToLast_2(ListNode head, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
            return list.get(list.size()-k);
        }

        //方法4.存到栈/队列里，实际上java的双端队列ArrayDeque可以实现栈和队列，所以都行
        public int kthToLast_3(ListNode head, int k) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            while (head != null){
                stack.offer(head.val); //入栈
                head = head.next;
            }
            while (--k > 0){
                stack.pollLast(); //出栈，如果是队列，则这里调用poll()或者pollFirst()，并循环stack.size()-k次
            }
            return stack.pollLast(); //出栈，如果是队列，则这里调用poll()或者pollFirst()
        }
    }
}
