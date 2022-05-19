package offer;

import tools.Asserts;

import java.util.Stack;

//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计 队列 👍 535 👎 0

public class _09_CQueue extends Asserts {

    public static void main(String[] args) {
        _09_CQueue app = new _09_CQueue();
        CQueue queue = new CQueue();
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }

    static class CQueue {

        Stack<Integer> head;
        Stack<Integer> tail;

        public CQueue() {
            head = new Stack();
            tail = new Stack();
        }

        public void appendTail(int value) {
            tail.push(value);
        }

        public int deleteHead() {
            if (head.isEmpty() && tail.isEmpty()) {
                return -1;
            } else if (head.isEmpty() && !tail.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
                return head.pop();
            } else {
                return head.pop();
            }
        }
    }
}
