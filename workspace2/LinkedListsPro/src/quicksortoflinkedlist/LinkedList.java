package quicksortoflinkedlist;

public class LinkedList<E extends Number> implements Cloneable {
	Node<E> head = null;
	Node<E> tail = null;

	// Adding at the End
	class Node<T extends Number> {
		T value;
		Node<T> nextReference;

		public Node(T value) {
			this.value = value;
			this.nextReference = null;
		}

		public Node(T value, Node<T> ref) {
			this.value = value;
			this.nextReference = ref;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNextReference() {
			return nextReference;
		}

		public void setNextReference(Node<T> nextReference) {
			this.nextReference = nextReference;
		}
	}

	public void add(E value) {
		Node<E> nodeToBeAdded = new Node<E>(value);
		;
		Node<E> l = tail;
		tail = nodeToBeAdded;
		if (validate(head)) {
			head = tail;
			return;
		}
		l.setNextReference(nodeToBeAdded);

	}

	Node<E> findApivot(Node<E> head, Node<E> tail) {
		Node<E> node = head;
		Node<E> pivot = tail;
		Node<E> prevnode = head;
		if (head == null || head.getNextReference() == null) {
			return head;

		}
		while (!node.equals(pivot)) {
			if (tail.getValue().doubleValue() < node.getValue().doubleValue()) {

				if (node.equals(head)) {
					head = node.getNextReference();
				}
				prevnode.setNextReference(node.getNextReference());
				Node<E> nodeToBeAdded = new Node<E>(node.getValue());
				Node<E> l = tail;
				tail = nodeToBeAdded;

				l.setNextReference(nodeToBeAdded);
				
				

			}else
			{
			prevnode = node;
			node = node.getNextReference();
			}

		}

		while (!head.equals(pivot)) {
			Node<E> nodeOfLeft = head;
			while (!nodeOfLeft.getNextReference().equals(pivot)) {
				nodeOfLeft = nodeOfLeft.nextReference;
			}
			nodeOfLeft.nextReference = null;
			head = findApivot(head, nodeOfLeft);
			nodeOfLeft = getTail(head);
			nodeOfLeft.setNextReference(pivot);
		}
		pivot.setNextReference(findApivot(pivot.getNextReference(), tail));
		// printAll(head) ;
		return head;
	}

	Node<E> getTail(Node<E> node) {
		Node<E> temp = node;
		while (temp != null && temp.getNextReference() != null) {
			temp = temp.nextReference;
		}
		return temp;
	}

	void printAll(Node<E> head) {
		Node<E> node = head;
		while (node != null) {
			System.out.println(node.getValue());
			node = node.getNextReference();
		}

	}

	public boolean validate(Node<E> head) {
		if (head == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		linkedList.add(10);
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(4);
		linkedList.add(8);
		linkedList.add(9);
		linkedList.add(7);
		// linkedList.printAll(linkedList.head);
		linkedList.printAll(linkedList.findApivot(linkedList.head,
				linkedList.tail));
		// linkedList.printAll(linkedList.reverseLinkedList(linkedList.head,3));

	}
// when life throws you rahul make it dravid not gandhi
}
