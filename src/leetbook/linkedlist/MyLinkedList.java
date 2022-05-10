package leetbook.linkedlist;

class MyLinkedList {

	private SNode head;

	public MyLinkedList() {

	}

	// get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
	public int get(int index) {
		int val = -1;
		SNode tmp = head;
		while (tmp != null) {
			if (index-- == 0) {
				return tmp.val;
			}
			tmp = tmp.next;
		}
		return val;
	}

	// addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
	public void addAtHead(int val) {
		SNode node = new SNode(val);
		node.next = head;
		head = node;
	}

	// addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
	public void addAtTail(int val) {
		SNode node = new SNode(val);
		SNode tmp = head;
		if (tmp == null){
			head = node;
		}
		while (tmp != null) {
			if (tmp.next == null) {
				tmp.next = node;
				break;
			}
			tmp = tmp.next;
		}
	}

	// addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
	public void addAtIndex(int index, int val) {
		if (index <= 0) {
			addAtHead(val);
			return;
		}
		SNode prev = null;
		SNode cur = new SNode(val);
		SNode tmp = head;
		while (tmp != null) {
			if (index == 0) {
				prev.next = cur;
				cur.next = tmp;
				break;
			}
			if (tmp.next == null && index > 0) {
				if (index == 1) {
					addAtTail(val);
					break;
				}
				return;
			}
			prev = tmp;
			tmp = tmp.next;
			index--;
		}

	}

	// deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
	public void deleteAtIndex(int index) {
		if (index == 0 ){
			if (head == null){
				return;
			}
			if (head != null && head.next == null){
				head = null;
				return;
			}
			if (head != null && head.next != null){
				head = head.next;
				return;
			}

		}
		SNode tmp = head;
		SNode prev = null;
		while (tmp != null) {
			if (index == 0){
				if (tmp.next == null){
					prev.next = null;
				} else {
					prev.next = tmp.next;
				}
			}
			prev = tmp;
			tmp = tmp.next;
			index--;
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		SNode tmp = head;
		while (tmp != null) {
			sb.append(tmp.val);
			tmp = tmp.next;
			if (tmp != null) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	private class SNode {

		private int val;
		private SNode next;

		public SNode() {
		}

		public SNode(int val) {
			this.val = val;
		}

		public SNode(int val, SNode next) {
			this.val = val;
			this.next = next;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public void setNext(SNode next) {
			this.next = next;
		}

	}

	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();
		list.addAtTail(1);
		System.out.println(list.get(0));

		// MyLinkedList list = new MyLinkedList();
		// int i = list.get(0);
		// System.out.println("get(0) = " + i);
		// list.addAtHead(111);
		// i = list.get(0);
		// System.out.println("get(0) = " + i);
		// list.addAtHead(222);
		// list.addAtHead(333);
		// System.out.println(list);
		// list.addAtIndex(0, 999);
		// System.out.println(list);
		// list.addAtIndex(1, 888);
		// System.out.println(list);
		// list.addAtIndex(11, 888);
		// System.out.println(list);
		// list.addAtIndex(4, 000);
		// System.out.println(list);
		// list.addAtIndex(6, -999);
		// System.out.println(list);
		// list.addAtTail(-1);
		// list.addAtTail(-2);
		// list.addAtTail(-3);
		// System.out.println(list);
		// System.out.println("==================delete====================");
		// list.deleteAtIndex(0);
		// System.out.println(list);
		// list.deleteAtIndex(8);
		// System.out.println(list);
		// list.deleteAtIndex(3);
		// System.out.println(list);
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */