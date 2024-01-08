package program;

import java.util.Arrays;
import java.util.List;

public class partition_list_lcci {
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
        List<Integer> list = Arrays.asList(1,1);
        for (int i = 0; i < 2; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.partition(root.next, 3);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode partition(ListNode head, int x) {
            if(head == null) return null;

            ListNode less = new ListNode(); //值均小于x的链表
            ListNode dummmy_less = less; //该链表的头结点
            ListNode greater = new ListNode(); //值均大于x的链表
            ListNode dummy_greater = greater; //该链表的头结点
            ListNode resList = new ListNode(); //答案链表
            int midCount = 0; //记录中间节点出现了几次
            ListNode dummmy = resList; //答案链表的头结点
            while(head != null){ //先遍历一遍数组，把小于x和大于x的分别放入不同的链表中
                if(head.val < x){ //该值如果小于x，就放入less链表
                    less.next = new ListNode(head.val);
                    less = less.next;
                }else if(head.val == x){ //该值如果等于x，就记录下出现了多少次
                    ++midCount;
                }else{ //该值如果大于x，就放入greater链表
                    greater.next = new ListNode(head.val);
                    greater = greater.next;
                }
                head = head.next;
            }
            //拼接前面的部分
            while(dummmy_less.next != null){
                resList.next = dummmy_less.next;
                dummmy_less = dummmy_less.next;
                resList = resList.next;
            }
            //拼接中间部分x
            while(midCount>0){
                resList.next = new ListNode(x);
                --midCount;
                resList = resList.next;
            }
            //拼接后面的部分
            while(dummy_greater.next != null){
                resList.next = dummy_greater.next;
                dummy_greater = dummy_greater.next;
                resList = resList.next;
            }
            return dummmy.next;
        }
    }
}
