package program;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _148 {
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
        ListNode head = solution.sortList(root);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null) return null;
            //优先队列，默认从小到大排序
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            //新链表头结点
            ListNode node = new ListNode();
            //新链表指针
            ListNode cur = node;
            //如果链表不为空，将链表中的值放入优先队列
            while(head!=null){
                queue.add(head.val);
                head = head.next;
            }
            //循环优先队列
            while(!queue.isEmpty()){
                //将值放入新链表当前节点中，该值出队列
                cur.val = queue.poll();
                //只有队列不为空时，才去新建节点，便于下一次保存值。为空代表已经将所有值放入新链表中，不用再新增节点了
                if(!queue.isEmpty()){
                    ListNode next = new ListNode();
                    cur.next = next;
                    cur = cur.next;
                }
            }
            return node;
        }
    }
}
