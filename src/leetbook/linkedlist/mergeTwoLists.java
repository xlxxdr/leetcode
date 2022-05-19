package leetbook.linkedlist;


import tools.Asserts;
import tools.ListNode;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class mergeTwoLists {

    public static void main(String[] args) {
        mergeTwoLists app = new mergeTwoLists();
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{1, 1, 2, 3, 4, 4}),
                app.mergeTwoLists(ListNode.parseListNodeFromArray(new int[]{1, 2, 4}),
                        ListNode.parseListNodeFromArray(new int[]{1, 3, 4})));
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{}),
                app.mergeTwoLists(ListNode.parseListNodeFromArray(new int[]{}),
                        ListNode.parseListNodeFromArray(new int[]{})));
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{0}),
                app.mergeTwoLists(ListNode.parseListNodeFromArray(new int[]{}),
                        ListNode.parseListNodeFromArray(new int[]{0})));

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        } else {
            ListNode newHead = null;
            ListNode newList = null;
            while (list1 != null && list2 != null) {
                ListNode tmp = null;
                if (list1.val <= list2.val) {
                    if (newList == null) {//第一次访问
                        newList = list1;
                        newHead = newList;
                    } else {//设置下一个节点为当前list1的节点
                        tmp = new ListNode(list1.val);
                        newList.next = tmp;
                        newList = tmp;
                    }
                    list1 = list1.next;
                    if (list1 == null && list2 != null) {
                        newList.next = list2;
                    }

                } else {
                    if (newList == null) {
                        newList = list2;
                        newHead = newList;
                    } else {
                        tmp = new ListNode(list2.val);
                        newList.next = tmp;
                        newList = tmp;
                    }
                    list2 = list2.next;
                    if (list2 == null && list1 != null) {
                        newList.next = list1;
                    }
                }
            }
            return newHead;
        }

    }
}
