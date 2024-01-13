package program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LCR_023 {
    // 链表节点
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
        ListNode head = solution.getIntersectionNode(root, root);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class Solution {
        //链表懒得构造了

        //方法1.哈希结构存储遍历过的节点
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }
    }

    //方法2.我走过你来时的路，而你也是如此，那么最后我们终会相遇
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != nodeB){
            nodeA = nodeA==null?headB:nodeA.next;
            nodeB = nodeB==null?headA:nodeB.next;
        }
        return nodeA;
    }
}