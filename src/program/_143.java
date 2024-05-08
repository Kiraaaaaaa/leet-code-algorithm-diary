package program;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class _143 {
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
        ListNode head = root.next;
        solution.reorderList(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public void reorderList(ListNode head) {
            ListNode cur = head;
            ArrayDeque<ListNode> stack = new ArrayDeque<>();
            while(cur != null){
                stack.add(cur);
                cur = cur.next;
            }
            cur = head;
            int step = 0;
            while(!stack.isEmpty()){
                step++;
                if(step%2 == 0){
                    cur = cur.next;
                    continue;
                }
                ListNode temp = cur.next;
                ListNode poll = stack.pollLast();
                if(cur == poll) break;
                cur.next = poll;
                poll.next = temp;
                cur = cur.next;
            }
            return;
        }
    }
}
