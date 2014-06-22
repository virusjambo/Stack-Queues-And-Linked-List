package reversetheelementwithgivensize;


public class LinkedList<E > implements Cloneable {
	Node<E> head = null;
	

	// Adding at the End
	class Node<T > {
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

	Node<E>  reverseLinkedList(Node<E> head,int k){
		Node<E> next=null;
		Node<E> prevNode=null;
		Node<E> currentNode=head;
		int count =0;
		while(currentNode!=null &&count<k){
			next=currentNode.nextReference;
			currentNode.setNextReference(prevNode);
			prevNode=currentNode;
			currentNode=next;
		count++;
		}
		if(next !=  null){
			head.setNextReference(next);	
	    count =0;
		Node<E> prevNode1=null;
		while(next.getNextReference()!=null && count<k){
			prevNode1=next;
			next=next.getNextReference();
			 count++;
		}
		head=prevNode1;
		}
		
		if(next !=  null)
	    {  reverseLinkedList(next, k)  ; 
			}
	 
		return prevNode;
	}

	
	void printAll(Node<E> head) {
		Node<E> node =head ;
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
		linkedList.add("8");
		linkedList.add("7");
		;
	
		linkedList.printAll(linkedList.reverseLinkedList(linkedList.head,3));

	}

}