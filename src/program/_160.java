package program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _160 {
    // 链表节点
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //构造链表结构
    private static ListNode buildList(int num) {
        return null;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.getIntersectionNode(null, null);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        //方法1.链表A在遍历的时候用HashSet存储节点，链表B在遍历时遇到即相交
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<>();
            while (headA != null){
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null){
                if(set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }
        //方法2.先记录较短链表和较长链表的长度差 1.让长链表先走过这个长度差的节点，然后较短链表再出发2.也可以给较短链表添加这个长度差的新节点，然后从头部一起出发。
        public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
            int lenA = 0, lenB = 0;
            ListNode curA = headA;
            ListNode curB = headB;
            while (curA != null){ //记录链表A的长度
                curA = curA.next;
                lenA++;
            }
            while (curB != null){ //记录链表B的长度
                curB = curB.next;
                lenB++;
            }
            if(lenA != lenB){ //两个链表长度不一致则先让长的链表先走
                if(lenA > lenB){ //链表A如果比较长，则让链表A先走
                    for (int i = 0; i < lenA - lenB; i++) {
                        headA = headA.next;
                    }
                }else{ //链表B如果比较长，则让链表B先走
                    for (int i = 0; i < lenB - lenA; i++) {
                        headB = headB.next;
                    }
                }
            }
            while (headA != headB){ //现在两链表长度一致了，遍历两个链表，遇到相同节点则返回
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
        //方法3.两链表各自走完后，就从另一条开始走，再次相遇就是同节点
        public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;
            while(curA != curB){
                if(curA == null){
                    curA = headB;
                }else{
                    curA = curA.next;
                }
                if(curB == null){
                    curB = headA;
                }else{
                    curB = curB.next;
                }
            }
/*            while (curA != curB){ //另一种写法，更简洁
                curA = curA == null ? headB : curA.next; //互相走过对方来时的路
                curB = curB == null ? headA : curB.next; //也注定会相遇
            }
            return curA == curB ? curA : null;*/
            return curA;
        }
    }
}
