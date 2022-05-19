package offer;

import tools.Asserts;
import tools.ListNode;

public class _25_mergeTwoLists extends Asserts {

    public static void main(String[] args) {
        _25_mergeTwoLists app = new _25_mergeTwoLists();

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
