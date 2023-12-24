package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ListNodeTemplate {
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
        List<Integer> list = Arrays.asList(5, 3, 4, 0);
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.method(root);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode method(ListNode head) {

            return head;
        }
    }
}
