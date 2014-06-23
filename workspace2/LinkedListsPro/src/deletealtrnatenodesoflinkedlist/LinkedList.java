package deletealtrnatenodesoflinkedlist;







public class LinkedList<E > implements Cloneable {
	Node<E> head = null;
	
//IF given linked list is 1 2 3 4 5 6 then result 
// 1 3 5
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

	void deleteNodes(){
		Node<E> node=head;
		Node<E> nextNode=node.getNextReference();
		while(node!=null && nextNode!=null){
			node.setNextReference(nextNode.getNextReference());
			node=node.getNextReference();
                        if(node!=null)
             nextNode=node.getNextReference();
			
			
		}
	}
	void recursiveDelete(Node<E> node1){
		Node<E> node=node1;
		if(node==null)
			return;
		Node<E> nextNode=node.getNextReference();
		if(node!=null && nextNode!=null){
			node.setNextReference(nextNode.getNextReference());
			recursiveDelete(node.getNextReference());		
		}
	}	
	void delete(){
		recursiveDelete(head);	
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		
		linkedList.add(1);
	
	
		linkedList.delete();
		linkedList.printAll();

	}

}


