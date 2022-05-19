package offer;


import tools.Asserts;
import tools.ListNode;

import java.util.LinkedList;
import java.util.List;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
public class _06_reversePrint {

    public static void main(String[] args) {
        _06_reversePrint app = new _06_reversePrint();
        Asserts.equals(new int[]{2, 3, 1}, app.reversePrint(ListNode.parseListNode(1, 3, 2)));
        Asserts.equals(new int[]{}, app.reversePrint(ListNode.parseListNode()));
        Asserts.equals(new int[]{1}, app.reversePrint(ListNode.parseListNode(1)));

    }

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = newHead;
            newHead = tmp;
            len++;
            head = head.next;
        }
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = newHead.val;
            newHead = newHead.next;
        }
        return nums;
    }
}
