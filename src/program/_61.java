package program;

import java.util.Arrays;
import java.util.List;

public class _61 {
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
        List<Integer> list = Arrays.asList(1,2,3);
        for (int i = 0; i < 3; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.rotateRight(root.next, 2000000000);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) return null;
            if(head.next == null) return head; //只有一个节点直接返回
            ListNode l = new ListNode(-1, head); //定义一个头结点的上级节点l，同来衔接尾节点
            ListNode r = head; //用来寻找尾节点
            int size = 0;
            while (r != null){
                size++;
                r = r.next;
            }
            k %= size; //取模，更新k为最少移动次数
            while(k-- > 0){
                r = l.next; //用来寻找尾节点的指针
                while(r.next != null && r.next.next != null){ //找到尾节点的前一个节点，也就是倒数第二个节点
                    r = r.next;
                }
                ListNode tail = r.next; //将尾节点保存
                r.next = null; //倒数第二个节点变成尾节点
                ListNode temp = l.next; //保存头结点
                l.next = tail; //尾节点变成头结点
                tail.next = temp; //新头节点连接旧头节点
            }
            return l.next;
        }
    }
}
