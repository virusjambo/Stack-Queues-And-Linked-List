package segregateevenadnoddnodes;

public class LinkedList<E extends Number> implements Cloneable {
	Node<E> head = null;

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
		Node<E> nodeToBeAdded = head;
		if (validate(head)) {
			head = new Node<E>(value);
			return;
		}

		while (nodeToBeAdded.getNextReference() != null) {
			nodeToBeAdded = nodeToBeAdded.getNextReference();
		}
		Node<E> node = new Node<E>(value);
		nodeToBeAdded.setNextReference(node);

	}

	void printAll(Node<E> head) {
		Node<E> node = head;
		while (node != null) {
			System.out.println(node.getValue());
			node = node.getNextReference();
		}

	}

	Node<E> tail = new Node<E>();
	Node<E> head1 = null;

	void researchOnreverse(Node<E> node) {

		if (node == null) {

			return;
		}
		researchOnreverse(node.getNextReference());
		System.out.println(node.getValue());
		add(node.getValue());

	}

	void segragateEvenAndOddNodes() {
		Node<E> node = head;
		Node<E> tail = null;
		int count = 0;
		int count1 = 0;
		while (node.getNextReference() != null) {

			node = node.getNextReference();
			count++;

		}
		tail = node;

		Node<E> prevNode = null;
		Node<E> currentNode = head;

		while (count1 < count + 1) {
			if (!((currentNode.getValue().doubleValue() % 2) == 0)) {

				Node<E> newNode = new Node<E>(currentNode.getValue());
				tail.setNextReference(newNode);
				tail = tail.getNextReference();
				if (prevNode != null) {
					prevNode.setNextReference(currentNode.getNextReference());

				}
				if (prevNode == null) {
					head = currentNode.getNextReference();
				}

			}
			prevNode = currentNode;
			currentNode = currentNode.getNextReference();
			count1++;
		}

	}

	void add(Node<E> val) {
		Node<E> node = new Node<E>(val.getValue());
		tail = node;
		if (head1 == null) {
			head1 = tail;
			return;
		}
		tail.setNextReference(node);
	}

	/*
	 * public void add(Node<E> evenNodes,E value) {
	 * 
	 * if (validate(head)) { head = node;
	 * 
	 * } else { tail.setNextReference(node); }
	 * 
	 * 
	 * }
	 */
	public boolean validate(Node<E> head) {
		if (head == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			linkedList.add(i);

		}

		linkedList.segragateEvenAndOddNodes();
		linkedList.printAll(linkedList.head);

	}

}