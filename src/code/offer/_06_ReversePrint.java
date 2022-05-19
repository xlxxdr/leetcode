package code.offer;

import tools.Asserts;
import tools.ListNode;

import java.util.Stack;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
限制：

0 <= 链表长度 <= 10000

Related Topics
栈
递归
链表
双指针
 */
public class _06_ReversePrint {

    public static void main(String[] args) {
        _06_ReversePrint app = new _06_ReversePrint();

        Asserts.equals(new int[]{2,3,1},app.reversePrint(ListNode.parseListNodeFromArray(new int[]{1,3,2})));
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = stack.pop();
        }
        return nums;
    }
}
