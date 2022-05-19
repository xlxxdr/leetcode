package leetbook.linkedlist;


import tools.Asserts;
import tools.ListNode;

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
public class removeElements {


    public static void main(String[] args) {
        removeElements app = new removeElements();
        // 输入：head = [1,2,6,3,4,5,6], val = 6
        // 输出：[1,2,3,4,5]
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{1, 2, 3, 4, 5})
                , app.removeElements(ListNode.parseListNodeFromArray(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        // 输入：head = [], val = 1
        // 输出：[]
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{})
                , app.removeElements(ListNode.parseListNodeFromArray(new int[]{}), 1));
        // 输入：head = [7,7,7,7], val = 7
        // 输出：[]
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{})
                , app.removeElements(ListNode.parseListNodeFromArray(new int[]{7, 7, 7, 7}), 7));

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode nulHead = new ListNode();
        nulHead.next = head;
        ListNode prev = nulHead;
        ListNode tmp = nulHead;
        while (tmp != null) {
            if (tmp.val == val) {//当前访问的链表节点为目标节点
                prev.next = tmp.next;//删除当前节点
                tmp = tmp.next;//移动到下一个节点
            } else { //当前访问的节点不为目标节点
                prev = tmp;
                tmp = tmp.next;
                if (tmp == null) { // 最后一个节点
                    prev.next = null;
                }
            }
        }
        // 返回去掉虚拟头结点的链表
        return nulHead.next;
    }
}
