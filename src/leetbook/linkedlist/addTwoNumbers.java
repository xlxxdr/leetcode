package leetbook.linkedlist;

//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0开头。


import tools.Asserts;
import tools.ListNode;

public class addTwoNumbers {

    public static void main(String[] args) {
        addTwoNumbers app = new addTwoNumbers();
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{7,0,8}),
                app.addTwoNumbers(ListNode.parseListNodeFromArray(new int[]{2,4,3})
                ,ListNode.parseListNodeFromArray(new int[]{5,6,4})));
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{0}),
                app.addTwoNumbers(ListNode.parseListNodeFromArray(new int[]{0})
                        ,ListNode.parseListNodeFromArray(new int[]{0})));
        Asserts.equals(ListNode.parseListNodeFromArray(new int[]{8,9,9,9,0,0,0,1}),
                app.addTwoNumbers(ListNode.parseListNodeFromArray(new int[]{9,9,9,9,9,9,9})
                        ,ListNode.parseListNodeFromArray(new int[]{9,9,9,9})));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retNode = null;
        ListNode newHead = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int num = (l1 == null ? 0 : l1.val) + (l2 == null ? 0:  l2.val);
            num+=carry;
            if (num >= 10){
                carry = 1;
                num = num % 10;
            } else {
                carry = 0;
            }
            if (retNode == null){
                retNode = new ListNode(num);
                newHead = retNode;
            } else {
                ListNode tmp = new ListNode(num);
                retNode.next = tmp;
                retNode = tmp;
            }
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        if (carry != 0){
            ListNode carryNode = new ListNode(carry);
            retNode.next = carryNode;
        }
        return newHead;
    }
}
