
public class LinkedList<E> implements Cloneable {
	Node<E> head = null;

	// Adding at the End
	class Node<T> {
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

	void pairWiseSwap() {
		Node<E> node = head;
		while (node != null && node.getNextReference() != null) {
			E temp = node.getValue();
			node.setValue(node.getNextReference().getValue());
			node.getNextReference().setValue(temp);
			node = node.getNextReference().getNextReference();

		}
	}
	
	void pairWiseSwapRecu(Node<E> head) {
		if(head != null && head.getNextReference() != null){
			swap(head);
			pairWiseSwapRecu(head.getNextReference().getNextReference());
		}

		
	}
	void swap(Node<E> node){
		E temp = node.getValue();
		node.setValue(node.getNextReference().getValue());
		node.getNextReference().setValue(temp);
	}
void	pairWiseSwapRecure(){
		pairWiseSwapRecu(head);	
	}
	void printAll() {
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
		LinkedList<String> linkedList = new LinkedList<String>();

		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		linkedList.add("6");
		linkedList.pairWiseSwapRecure();
		// linkedList.recursiveReverse1();
		linkedList.printAll();

	}

}
