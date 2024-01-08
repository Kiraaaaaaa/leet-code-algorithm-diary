package program;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class remove_duplicate_node_lcci {
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
        List<Integer> list = Arrays.asList(1,1,1,1,2);
        for (int i = 0; i < 5; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.removeDuplicateNodes(root.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if(head==null) return null;
            HashSet<Integer> set = new HashSet<>();
            ListNode root = head;
            while(root.next != null){
                ListNode next = root.next;
                set.add(root.val);
                if(set.contains(next.val)){
                    root.next = root.next.next;
                }else{
                    root = next;
                }
            }
            return head;
        }
    }
}
