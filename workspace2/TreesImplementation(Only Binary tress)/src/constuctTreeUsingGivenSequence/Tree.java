package constuctTreeUsingGivenSequence;

import createtreeusingagivearray.Node;



public class Tree<E> {
	String P[]={"A","B","C","D","E"};
	String PL[]={"N","N","L","L","L"};
	int len=P.length;
	int index=0;
	
	Node<E> createTree(){
		if(index==len)
			return null;
		Node<E> temp=(Node<E>) new Node<>(P[index]);
		
		if(PL[index++].equals("N")){
			temp.setLeftRef(createTree());	
			temp.setRightRef(createTree());
		}
		return temp;
		
	}
	void printAll1(Node<E> root){
		if(root==null)
			return;
		printAll1(root.getLeftRef());
		printAll1(root.getRightRef());
		System.out.println(root.getValue());
	}
	public static void main(String[] args) {
	Tree<String> nt=new Tree<>();
	nt.printAll1(nt.createTree());
	
	}
	
	

}
