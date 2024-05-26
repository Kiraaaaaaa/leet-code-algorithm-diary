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
        List<Integer> list = Arrays.asList(1,2,3,4);
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = root.next;
        solution.reorderList_1(head);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class Solution {

        //方法1.个人思路（节点入栈，出栈插入即可，如果到中间节点mid，则结束插入）
        public void reorderList(ListNode head) {
            ListNode cur = head;
            ArrayDeque<ListNode> stack = new ArrayDeque<>(); // 所有节点入栈，插入的时候取出栈顶节点即可
            int count = 0; // 节点个数
            while(cur != null){ // 入栈并记录节点长度
                stack.add(cur);
                cur = cur.next;
                count++;
            }
            cur = head;
            int mid = count / 2;
            while(!stack.isEmpty()){
                count--;
                ListNode temp = cur.next; // 保存当前节点的下一个节点
                ListNode poll = stack.pollLast(); // 弹出栈顶节点
                cur.next = poll; // 当前节点的下一个节点指向栈顶节点
                if(count == mid){ // count == mid则说明当前节点的下一个节点poll已经是最后一个节点，结束循环
                    poll.next = null;
                    break;
                }
                poll.next = temp; // 栈顶节点的下一个节点指向当前节点的下一个节点
                cur = temp; // 当前节点指向下一个节点
            }
            return;
        }

        //方法2.快慢指针寻找中间节点+反转后半段链表+左右双指针遍历
        public void reorderList_1(ListNode head) {
            ListNode mid = findMid(head); // 寻找中间节点
            ListNode head2 = reverse(mid); // 反转后半段链表
            while(head2.next != null){ //只要后半段链表还有节点（不包括中间节点，所以是head2.next），则进行左右双指针遍历
                ListNode next = head.next; // 前一个链表保存下一个节点
                ListNode next2 = head2.next;  // 后一个链表保存下一个节点
                head.next = head2; // 后半段的节点连接到前半段中
                head2.next = next; // 后半段节点连接前半段节点的后面
                head = next; // 前半段节点遍历自己的下一个节点
                head2  = next2; // 后半段节点遍历自己的下一个节点
            }
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next; // 保存当前节点的下一个节点
                cur.next = pre; // 当前节点的下一个节点变为前一个节点
                pre = cur; // 前一个节点变为当前节点
                cur = next; // 前面保存的下一个节点作为当前节点
            }
            return pre;
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head, slow = head;
            while(fast != null && fast.next != null){ // 快慢指针寻找中间节点
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow; // 如果链表长度为奇数，则slow为中间节点，否则slow为中间索引的前一个节点
        }

    }
}
