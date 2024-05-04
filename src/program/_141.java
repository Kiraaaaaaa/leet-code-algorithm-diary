package program;

import java.util.*;

public class _141 {
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
        boolean res = solution.hasCycle_1(root.next);
        System.out.println(res);
    }
    public static class Solution {

        //方法1.快慢指针，如果有环，快的一定追上慢的。如果fast为null说明不存在环
        public boolean hasCycle(ListNode head) {
            if(head == null) return false;
            ListNode fast = head.next; //快指针先走一位，防止第一步就判断为相遇
            ListNode slow = head;
            while(fast != null && fast.next != null){ //注意一定要判断fast指针下一个节点是否为空。
                if(fast == slow) return true; //如果两指针相遇说明在环中循环了
                fast = fast.next.next; //快指针每次走两步
                slow = slow.next; //慢指针每次走一步
            }
            return false; //如果fast走到链表尽头了说明不存在环
        }

        //方法2.set存访问过的节点
        public boolean hasCycle_1(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            while (!set.contains(head)){
                if(head == null) return false;
                set.add(head);
                head = head.next;
            }
            return true;
        }

        //方法3.投机取巧，让指针移动用例中的最大节点个数，如果超过了这个数字都还没有到null，则说明陷入循环了
        public boolean hasCycle_2(ListNode head) {
            for (int i = 0; i < 10000; i++) {
                if(head == null) return false; //如果遍历到null说明不是环
                head = head.next;
            }
            return head != null; // 如果链表都遍历完了，这里指针应该是null，否则就是环
        }
    }
}
