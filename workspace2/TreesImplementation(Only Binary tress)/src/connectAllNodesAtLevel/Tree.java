package connectAllNodesAtLevel;

import java.util.LinkedList;
import java.util.Queue;

import connectAllNodesAtLevel.Tree.Node;

import createtreeusingagivearray.BinaryTree;


public class Tree<E> {
	/*1->null
	/\
    3->4->null
   /\ /\
  6->7->9->8->null*/
	
//METHOD 1:Using level order traverse using a queue with identifier so can separate each level
	//Space complexity n time 0(n)
	
Queue<Node<E>> queue=new LinkedList<>();

void connectAllNodes(Node<E> root,Node<E> del){
	if(root==null)
		return;
	queue.add(root);
	queue.add(del);
	
	while(!queue.isEmpty()){
		Node<E> temp=queue.poll();
		if(temp.leftRef!=null)
			queue.add(temp.leftRef);
		if(temp.rightRef!=null)
			queue.add(temp.rightRef);
		Node<E> temp1=queue.peek();
		if(temp1==null){
			break;
		}
		if(temp1.equals(del)){
			temp.nextRightRef=null;
			queue.poll();
			queue.add(del);
		}
		else{
			temp.nextRightRef=temp1;
		}
		
	}
	
}
void printAll(Node<E> root){
	if(root==null)
		return;
	printAll(root.getLeftRef());
	printAll(root.getRightRef());
	System.out.println(root.getValue());
}

void printAll1(Node<E> root){
	if(root==null)
		return;
	printAll1(root.getLeftRef());
	printAll1(root.getRightRef());
	System.out.println(root.nextRightRef!=null ?root.nextRightRef.getValue():-1);
}
	
	public static void main(String[] args) {
		Tree<String> it=new Tree<>();
		@SuppressWarnings("rawtypes")
		Tree.Node del=it.new Node<>("DEL");
		Tree.Node del1=it.new Node<>("A");
		Tree.Node del12=it.new Node<>("B");
		Tree.Node del13=it.new Node<>("C");
		Tree.Node del14=it.new Node<>("D");
		Tree.Node del125=it.new Node<>("E");
		Tree.Node del136=it.new Node<>("F");
		del1.setLeftRef(del12);
		del1.setRightRef(del13);
		del12.setLeftRef(del14);
		del12.setRightRef(del125);
		del13.setLeftRef(del136);
		it.printAll(del1);
		it.connectAllNodes(del1,del);
		System.out.println("output");
		it.printAll1(del1);
	}
	 class Node<E> {
		Node<E> leftRef;
		public Node<E> getLeftRef() {
			return leftRef;
		}
		public void setLeftRef(Node<E> leftRef) {
			this.leftRef = leftRef;
		}
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node<E> getRightRef() {
			return rightRef;
		}
		public void setRightRef(Node<E> rightRef) {
			this.rightRef = rightRef;
		}
		E value;
		Node<E> rightRef;
		Node<E> nextRightRef;
		public Node(E value){
			this.value=value;
			this.rightRef=null;
			this.leftRef=null;
			this.nextRightRef=null;
			
		}
		public Node(Node<E> leftRef, E value,Node<E> rightRef,Node<E> nextRightRef){
			this.value=value;
			this.rightRef=leftRef;
			this. rightRef=rightRef;
			this.nextRightRef=nextRightRef;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		
		

	}

}
