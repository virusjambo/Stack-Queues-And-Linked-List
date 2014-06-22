package intersectionoftwosortedlinkedlist;

import java.util.ArrayList;
import java.util.List;





public class LinkedList<E extends Number> implements Cloneable {
	Node<E> head = null;
	List<E> list=new ArrayList<>();

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

 List<E>	intersectionUsingIterations(LinkedList<E> linkedList,LinkedList<E> linkedList1){
	Node<E> head1=linkedList.head;
	Node<E> head2=linkedList1.head;
	while(head1!=null && head2!=null){
		if(head1.getValue().doubleValue()>head2.getValue().doubleValue())
			head2=head2.getNextReference();
		if(head1.getValue().doubleValue()<head2.getValue().doubleValue())
			head1=head1.getNextReference();
		if(head1.getValue().doubleValue()==head2.getValue().doubleValue()){
		    list.add(head1.getValue());
		   head2=head2.getNextReference();
		    head1=head1.getNextReference();
		}
	}
	return list;
	
	}
 
 List<E>	intersectionUsingRecursive(Node<E> head1,Node<E> head2){
		
		if(head1==null || head2==null)
			return null;
	    
		if(head1.getValue().doubleValue()>head2.getValue().doubleValue())
				intersectionUsingRecursive(head1,head2.getNextReference());
			if(head1.getValue().doubleValue()<head2.getValue().doubleValue())
				intersectionUsingRecursive(head1.getNextReference(),head2);
				
			if(head1.getValue().doubleValue()==head2.getValue().doubleValue()){
				intersectionUsingRecursive(head1.getNextReference(),head2.getNextReference());
				list.add(head1.getValue());
			}
			return list;	
			   
			}
	List<E> recursiveCall(LinkedList<E> linkedList,LinkedList<E> linkedList1){
		return intersectionUsingRecursive(linkedList. head,linkedList1. head);
	}	
		
		
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		
		linkedList1.add(1);
		linkedList1.add(2);

		linkedList1.add(4);
		linkedList1.add(7);
		List<Integer> list=    linkedList.recursiveCall(linkedList,linkedList1);
		for(Integer i:list)
			System.out.println(i);

	}

}


