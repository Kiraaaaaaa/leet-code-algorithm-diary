package program;

import java.util.Arrays;
import java.util.List;

public class _83 {
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
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 3);
        for (int i = 0; i < 5; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.deleteDuplicates_1(root.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        //迭代
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return null;
            ListNode dummyNode = head;
            while(head != null && head.next != null){
                ListNode next = head.next;
                if(next.val == head.val) head.next = head.next.next;
                else head = head.next;
            }
            return dummyNode;
        }
        //递归方法，过程模拟：
        //1->1->2->3->3
        //1->2->3->3
        //1->2->3
        public ListNode deleteDuplicates_1(ListNode head) {
            //如果到达链表最后一个节点返回其自身
            if(head == null || head.next == null) return head;
            //先跳过重复值节点，直接把不同值的节点作为下一个节点
            while(head.next != null && head.val == head.next.val) head.next = head.next.next;
            //递归调用，把下一个节点作为参数传入，去掉其重复值节点
            head.next = deleteDuplicates_1(head.next);
            //返回去重后的节点，最后会串联起来
            return head;
        }
    }
}
