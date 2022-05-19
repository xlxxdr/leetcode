package code.linkedlist;

import tools.ListNode;

import java.util.LinkedList;

public class _206_reverseList {

    public static void main(String[] args) {
        _206_reverseList app = new _206_reverseList();
        ListNode node = app.reverseList(ListNode.parseListNodeFromArray(new int[]{1, 2, 4, 5, 6}));
        ListNode.print(node);

    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        LinkedList<ListNode> nodes = new LinkedList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        for (int i = (nodes.size() - 1); i > 0; i--) {
            ListNode node = nodes.get(i);
            ListNode next = nodes.get(i - 1);
            node.next = next;
            next.next = null;
        }
        return nodes.getLast();
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseRoot = head;

        while (head.next != null) {
            ListNode next = head.next;

        }


        ListNode pre = head.next;
        head.next = null;
        pre.next = reverseRoot;
        while (pre.next != null) {
            ListNode tmp = pre.next;

        }
        while (head != null) {

            head = head.next;
        }
        return reverseRoot;
    }

}
