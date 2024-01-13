package program;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class LCR_027 {
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
        List<Integer> list = Arrays.asList(1,0,1,1,1);
        for (int i = 0; i < 3; i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = buildList();
        boolean res = solution.isPalindrome_1(root);
        System.out.println(res);
    }
    public static class Solution {
        //开始正序遍历的节点
        ListNode root;
        // 方法1：递归，
        // 思路：在递归回溯的时候，此时的节点和正序移动的结点进行比较，如果和正序结点的值不一样就返回false，如果和正序结点的值一样就继续递归下去，直到递归回溯到正序节点和逆序节点重逢
        public boolean isPalindrome(ListNode head) {
            //先得到正序结点
            root = head;
            //将头结点的下一个节点作为递归的入口
            return check(head.next);
        }
        private boolean check(ListNode head) {
            if(head == null) return true;
            //优化内容，如果倒序遍历和正序遍历的节点一样就说明到达了链表中间，能走到这里说明其它节点比较后都没问题，所以肯定是回文链表
            if(head == root) return true;
            //先递归下去，从后向前遍历每个节点是否和前面的节点值是一样的，'&&'用来使其只要有一个节点值对不上就永远返回false
            boolean res = check(head.next) && (root.val == head.val);
            //比较完之后正序结点也需要移动到下一个节点
            root = root.next;
            //返回每次正逆序的两个节点比较结果
            return res;
        }

        //方法2.使用栈(还有bug) todo
        //思路：每遍历一个节点就将其值压入栈中，当遍历的节点值等于栈顶元素时，将栈中的值和正序遍历的节点值进行比较，如果不一样就直接返回false，如果一样就出栈并继续遍历下一个节点，直到链表的最后一个节点遍历完，如果栈中还有值则不是回文链表
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        public boolean isPalindrome_1(ListNode head) {
            //获得第一个节点
            ListNode cur = head.next;
            //是否为回文链表
            boolean flag = false;
            while (cur != null) {
                //如果栈为空，便是第一个节点，将当前节点压入栈中
                if (stack.isEmpty()) {
                    if(cur.next == null) return true;
                    stack.add(cur.val);
                } else {
                    if(stack.peek() == cur.next.val){
                        //设置当前的比较结果为true
                        flag = true;
                        //并将栈顶元素出栈，准备判断下一个栈顶元素和当前节点的值是否相等
                        System.out.println(stack);
                        stack.pop();
                        cur = cur.next;
                    }
                    //如果栈不为空，则将当前节点的值和栈顶元素进行比较
                    else if (stack.peek() == cur.val) {
                        //设置当前的比较结果为true
                        flag = true;
                        //并将栈顶元素出栈，准备判断下一个栈顶元素和当前节点的值是否相等
                        stack.pop();
                    } else if (flag) {
                        //如果当前节点的值和栈顶元素的值不相等，并且之前已经比较过了，则不是回文链表
                        return false;
                    } else {
                        //以上情况都不是，则还没有开始判断，将当前节点的值压入栈中
                        stack.push(cur.val);
                    }
                }
                cur = cur.next;
            }
            //如果链表中没有重复的值，就不是回文链表
            return stack.isEmpty();
        }
    }
}
