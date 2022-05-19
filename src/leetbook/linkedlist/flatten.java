package leetbook.linkedlist;

//你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的 子指针 
// 。这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。
// 这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的 多层数据结构 。
//给定链表的头节点head，将链表 扁平化 ，以便所有节点都出现在单层双链表中。让 curr 是一个带有子列表的节点。
// 子列表中的节点应该出现在扁平化列表中的curr 之后 和curr.next之前 。
//返回 扁平列表的 head。列表中的节点必须将其 所有 子指针设置为null。


public class flatten {

    public static void main(String[] args) {
        flatten app = new flatten();
        Node node = new Node(1);
        Node next = new Node(3);
        Node child = new Node(2);
        node.next = next;
        next.prev = node;
        node.child = child;
        child.prev = node;
        Node flatten = app.flatten(node);
        System.out.println("flatten = " + flatten);

    }

    Node H;

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        H = new Node();
        Node temp = H;
        See(head);
        temp.next.prev = null;
        return temp.next;
    }

    public void See(Node temp) {
        H.next = new Node();
        H.next.val = temp.val;
        H.next.prev = H;
        H = H.next;
        if (temp.child != null) {
            See(temp.child);
        }

        if (temp.next != null) {
            See(temp.next);
        }
    }


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
