package program;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _23 {
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
        List<Integer> list = Arrays.asList(1,4,5);
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // ListNode root = buildList();
        ListNode[] listNodes = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        listNodes[0] = node1;
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        listNodes[1] = node2;
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        listNodes[2] = node3;
        ListNode head = solution.mergeKLists(listNodes);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        //方法1.把每个节点放到堆中排序，按序取出即可，但是方法2更好
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> que = new PriorityQueue<>((i,j)->{return i.val - j.val;});
            for (ListNode list : lists) {
                while(list != null){
                    que.add(list);
                    list = list.next;
                }
            }
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (que.size() > 0){
                cur.next = que.poll();
                cur = cur.next;
            }
            return dummy.next;
        }
    }
    //方法2.同样使用堆，但是先存储每个链表的头结点，每次取出堆顶元素，并把堆顶元素的下一个节点放到堆中
    public static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> que = new PriorityQueue<>((i,j)->{return i.val - j.val;});
            for (ListNode list : lists) {
                que.add(list);
            }
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (que.size() > 0){
                ListNode node = que.poll();
                cur.next = node;
                if(node.next != null) que.add(node.next);
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
