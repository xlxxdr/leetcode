package leetbook.linkedlist;

import tools.ListNode;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class reverseList {

    public static void main(String[] args) {
        reverseList app = new reverseList();
        ListNode list = ListNode.parseListNodeFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode reverseList = app.reverseList(list);
        ListNode.print(reverseList);

    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tmp;
        while (head != null){
            // 这里新建节点是因为引用关系，如果直接tmp = head，则下一步会将head.next = null赋值成功
            tmp = new ListNode(head.val);
            tmp.next = newHead;
            newHead = tmp;
            head = head.next;
        }
        return newHead;
    }
}
