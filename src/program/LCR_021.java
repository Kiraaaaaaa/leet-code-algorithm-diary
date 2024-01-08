package program;

import java.util.Arrays;
import java.util.List;

public class LCR_021 {
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
        ListNode head = solution.removeNthFromEnd_1(root.next, 2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        // 递归删除倒数第n个结点;
        int count = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null) return null;
            ListNode node = removeNthFromEnd(head.next, n);
            ++count; // 代表当前是倒数第几个结点;
            if(count == n){ // 如果第n个结点就删除该结点（不返回当前结点，而返回下一个结点）
                return head.next;
            }else{ // 不是第n个结点，就直接连接上即可
                head.next = node;
            }
            return head;
        }

        public ListNode removeNthFromEnd_1(ListNode head, int n) {
            // 虚拟头结点， 统一head结点的操作;
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode fast = dummy;
            ListNode low = dummy;
            while (fast != null) { // 让快慢指针之间的距离保持 n + 1;
                if (n >= 0) {      // 如果fast没有到null，那么low指针就是倒数第n个结点的
                    fast = fast.next; // 的前一个结点，可以直接删除.
                    --n;
                } else {
                    low = low.next;
                    fast = fast.next;
                }
            }
            if (n >= 0) return dummy.next; // 如果没有倒数第n个结点
            low.next = low.next.next; // 删除倒数第n个结点
            return dummy.next;
        }
    }
}
