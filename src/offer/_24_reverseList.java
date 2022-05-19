
package offer;

import tools.ListNode;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
public class _24_reverseList {

    public static void main(String[] args) {
        _24_reverseList app = new _24_reverseList();

    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = newHead;
            newHead = tmp;
            head = head.next;
        }
        return newHead;
    }
}
