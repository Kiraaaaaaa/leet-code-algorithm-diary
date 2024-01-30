package program;

import java.util.Arrays;
import java.util.List;

public class _1669 {
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
        List<Integer> list = Arrays.asList(0,1,2,3,4,5);
        for (int i = 0; i < 6; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    private static ListNode buildList_1() {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        List<Integer> list = Arrays.asList(1000000,1000001,1000002);
        for (int i = 0; i < 3; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode root2 = buildList_1();
        ListNode head = solution.mergeInBetween(root.next, 3, 4, root2.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode pre = list1, tail = list1; //两个节点分别为，list1接上list2的前半部分，list1的尾部
            while(--a > 0){ //找到截断前的节点
                pre = pre.next;
            }
            while(b-- > 0){ //找到需要被截断的最后一个节点
                tail = tail.next;
            }
            pre.next = list2; //将list2接在pre节点后面
            while(pre.next != null){ //将节点更新到连接后的末尾
                pre = pre.next;
            }
            pre.next = tail.next; //将保存的尾部节点连接到pre节点后面
            // tail.next = null;
            return list1;
        }
    }
}
