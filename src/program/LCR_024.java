package program;

import java.util.Arrays;
import java.util.List;

public class LCR_024 {
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
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        for (int i = 0; i < 5; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.reverseList(root.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            while(cur!=null){
                //保存当前节点的下一个节点
                ListNode next = cur.next;
                //设置当前节点的下一个节点为上一个节点
                cur.next = pre;
                //更新上一个节点为当前节点
                pre = cur;
                //当前节点移动到保存的下一个节点
                cur = next;
            }
            //返回经过反转后的链表头节点
            return pre;
        }
    }
}
