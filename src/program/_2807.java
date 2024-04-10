package program;

import java.util.Arrays;
import java.util.List;

public class _2807 {
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
        List<Integer> list = Arrays.asList(18, 6, 10, 3);
        for (int i = 0; i < 4; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        ListNode head = solution.insertGreatestCommonDivisors(root.next);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode l = head; //定义一个左指针
            ListNode r = head.next; //在左指针右边一位定义一个右指针
            while(r != null){ //只要右指针不为空，那么左右指针他们之间必定有一个公约数
                int val = find(l.val, r.val); //找到左右指针的公约数
                l.next = new ListNode(val); //插入到链表中
                l.next.next = r;
                l = l.next.next; //更新左指针移动两次，到达右指针的位置
                r = r.next; //右指针移动一次
            }
            return head;
        }
        private int find(int num_1, int num_2) {
            int res = 1;
            int n = num_1 > num_2 ? num_2 : num_1; //找到两个数中的较小值
            while(n != 1){
                if(num_1%n == 0 && num_2%n == 0){ //从大到小枚举，找到最大公约数
                    res = n;
                    break;
                }
                n--;
            }
            return res;
        }
    }
}
