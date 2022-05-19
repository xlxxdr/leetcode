package leetbook.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class copyRandomList {

    public static void main(String[] args) {
        copyRandomList app = new copyRandomList();
        Node head = new Node(1);
        Node next1 = new Node(2);
        head.next = next1;
        head.random = next1;
        next1.random = next1;
        Node node = app.copyRandomList(head);
        System.out.println("node = " + node);

    }

    public Node copyRandomList(Node head) {
        // 用于记录每个node的位置。用于indexOf(Node)确定random的坐标，因为可能存在相同的val，所以不可用
        LinkedList<Node> nodeList = new LinkedList();
        LinkedList<Node> newNodeList = new LinkedList<>();
        Node tmp = head;
        Node tmpHead = new Node(-1);
        Node newHead = tmpHead;
        while (tmp != null){
            // 这里先完成了一个链表的复制，不包含random节点
            Node node = new Node(tmp.val);
            tmpHead.next = node;
            tmpHead = node;
            nodeList.add(tmp);
            newNodeList.add(node);
            tmp = tmp.next;
            if (tmp == null){
                // 不包含random的链表复制完成，现在开始复制random的部分
                Node rNode = head;
                Node nrNode = newHead.next;
                while (rNode != null){
                    if (rNode.random != null){
                        Node random = rNode.random;
                        int pos = nodeList.indexOf(random);
                        nrNode.random = newNodeList.get(pos);
                    }
                    rNode = rNode.next;
                    nrNode = nrNode.next;
                }
            }
        }
        return newHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
