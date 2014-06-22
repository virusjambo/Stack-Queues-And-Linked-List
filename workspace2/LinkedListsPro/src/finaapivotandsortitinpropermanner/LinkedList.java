package finaapivotandsortitinpropermanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




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

	public boolean validate(Node<E> head) {
		if (head == null) {
			return true;
		}
		return false;
	}

	Node<E> sortWithPivot(Node<E> head) {
		Node<E> tail = findTail(head);
		Node<E> pivot = tail;
		Node<E> next = head;
		Node<E> prev = null;
		while (!pivot.equals(next)) {
			if (pivot.getValue().doubleValue() < next.getValue().doubleValue()) {
                           
				Node<E> node = new Node<E>(next.getValue());
				tail.setNextReference(node);
				tail = node;
                                
                                  if(prev==null
                                      ){
                                head=next.nextReference;
                                next = next.nextReference;
                                continue;
                            }
                                  
				prev.setNextReference(next.nextReference);
                                next = next.nextReference;
				
			}else{
			prev = next;
			next = next.nextReference;
			}
		}
                Node<E> temp=head;
                Node<E> head2=head;
                while(!temp.equals(pivot)){
                 temp=temp.nextReference;   
                }
                head2=temp.nextReference;
                temp.nextReference=null;
                sortWithPivot(head);
                sortWithPivot(head2);
                return head;

	}

	Node<E> findTail(Node<E> node) {
		Node<E> temp = node;
		while (!(temp.nextReference == null)) {
			temp = temp.nextReference;
		}
		return temp;
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		linkedList.add(9);
		linkedList.add(7);
		linkedList.add(1);
		linkedList.add(4);
		linkedList.add(8);
		linkedList.add(5);

		//linkedList.add(1);

		;
		linkedList.printAll(linkedList.sortWithPivot(linkedList.head));

	}

}
