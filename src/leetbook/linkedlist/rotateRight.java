package leetbook.linkedlist;

import tools.Asserts;
import tools.ListNode;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
public class rotateRight {

    public static void main(String[] args) {
        rotateRight app = new rotateRight();
        Asserts.equals(ListNode.parseListNode(0),
                app.rotateRight(ListNode.parseListNode(0), 5));
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{1, 2, 3, 4, 5}),
                app.rotateRight(ListNode.parseListNodeFromArray(new int[]{1, 2, 3, 4, 5}), 5));
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{4, 5, 1, 2, 3}),
                app.rotateRight(ListNode.parseListNodeFromArray(new int[]{1, 2, 3, 4, 5}), 2));
        Asserts.equals(ListNode.parseListNode(2, 0, 1),
                app.rotateRight(ListNode.parseListNode(0, 1, 2), 4));

    }

    public ListNode rotateRight(ListNode head, int k) {
        // 解题思路:类似于求链表的倒数第n个节点
        // 快慢指针，快指针先走k步，当快指针走到了链表最后一个节点的next为null的时候，
        // 此时慢指针刚好指向倒数第k个节点，然后拼接链表
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode lenHead = head;
        int len = 0;
        while (lenHead != null){
            len++;
            lenHead = lenHead.next;
        }
        k = k % len;
        if (k == 0){
            return head;
        }
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }
}
