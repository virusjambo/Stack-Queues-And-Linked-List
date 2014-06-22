package reverseAStack;

public class Node<T> {
	T value;
	Node<T> nextRef;
	public Node(T value){
		this.value=value;
		this.nextRef=null;
		
	}
	public Node(Node<T> nextRef, T value){
		this.value=value;
		this.nextRef=nextRef;
		
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
	public Node<T> getNextRef() {
		return nextRef;
	}
	public void setNextRef(Node<T> nextRef) {
		this.nextRef = nextRef;
	}
	
	

}
