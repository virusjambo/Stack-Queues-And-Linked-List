package createtreeusingagivearray;



public class Node<T> {
	Node<T> leftRef;
	public Node<T> getLeftRef() {
		return leftRef;
	}
	public void setLeftRef(Node<T> leftRef) {
		this.leftRef = leftRef;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getRightRef() {
		return rightRef;
	}
	public void setRightRef(Node<T> rightRef) {
		this.rightRef = rightRef;
	}
	T value;
	Node<T> rightRef;
	public Node(T value){
		this.value=value;
		this.rightRef=null;
		this.leftRef=null;
		
	}
	public Node(Node<T> leftRef, T value,Node<T> rightRef){
		this.value=value;
		this.rightRef=leftRef;
		this. rightRef=rightRef;
	}
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}

