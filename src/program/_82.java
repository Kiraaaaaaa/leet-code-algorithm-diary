package program;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class _82 {
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
        List<Integer> list = Arrays.asList(1,2,3,3,4,4,5);
        for (int i = 0; i < 7; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.deleteDuplicates(root.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head); //头结点
            ListNode cur = dummy;
            //当还存在两个节点时，进行比较
            while(cur.next!=null && cur.next.next!=null){
                int val = cur.next.val; //取出前者节点的值
                //如果两节点值一样，则删除后一个节点，不断循环这一过程
                if(cur.next.next.val == val){
                    while(cur.next != null && cur.next.val == val){
                        cur.next = cur.next.next;
                    }
                }else{
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
}
