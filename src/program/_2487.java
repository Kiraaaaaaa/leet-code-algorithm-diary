package program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _2487 {
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
        List<Integer> list = Arrays.asList(1,1,1,1);
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.removeNodes(root.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode removeNodes(ListNode head) {
            //1.先记录下链表从大到小排序的值
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); //定义一个优先队列存储链表右侧最大值
            ListNode root = head;
            while(root != null){
                queue.add(root.val);
                root = root.next;
            }
            //2.开始正式遍历链表，如果当前节点的值小于优先队列的最大值，则删除当前节点
            ListNode dummy = new ListNode(0); //定义一个头结点，方便后序删除节点
            dummy.next = head;
            ListNode pre = dummy; //定义一个前驱指针
            ListNode cur = head; //定义一个当前指针
            while(cur != null){
                if(cur.val < queue.peek()){
                    pre.next = cur.next; //只要当前节点的值小于优先队列的最大值，则删除当前节点
                }else{
                    pre = cur; //当前节点值等于优先队列最大值的话，前驱节点指向当前节点
                }
                queue.remove(cur.val); //优先队列移除当前节点的值
                cur = cur.next; //当前指针后移
            }
            return dummy.next;
        }
    }
}
