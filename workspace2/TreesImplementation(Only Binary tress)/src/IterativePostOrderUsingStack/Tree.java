package IterativePostOrderUsingStack;

import java.util.Stack;



import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree< E> {
void 	TraverseTreeUsingTwoStack(Node<E> root){
	Stack<Node<E>> stack1=new Stack<>();
	Stack<Node<E>> stack2=new Stack<>();
	stack2.push(root);
	while(!stack1.isEmpty()||!stack2.isEmpty()){
		while(!stack2.isEmpty()){
			Node<E> temp=stack2.pop();
			if(temp.getLeftRef()!=null)
				stack2.push(temp.getLeftRef());
			if(temp.getRightRef()!=null)
				stack2.push(temp.getRightRef());
			stack1.push(temp);
		}
		System.out.println(stack1.pop().getValue());
	}
	}

Stack<Node<E>> stack3=new Stack<Node<E>>();
void traverseTreeUsingSingleStack(Node<E> root){
	
	
	do{
		while(root!=null){
			if(root.getRightRef()!=null)
				stack3.push(root.getRightRef());
			stack3.push(root);
			root=root.getLeftRef();
		}
		root=stack3.pop();
		if(root.getRightRef()!=null && root.getRightRef().equals(stack3.peek())){
			stack3.pop();
			stack3.push(root);
			root=root.getRightRef();
		}else{
			System.out.print(root.getValue());
			root=null;
		}
		
		
	}while(!stack3.isEmpty());
}

public static void main(String[] args) {
	BinaryTree<Integer> bt=new BinaryTree<>();
	Integer[] arr={1,2,3,4,5,6,7};
	bt.covertToTree(arr);
	Tree<Integer> it=new Tree<>();
	it.traverseTreeUsingSingleStack(bt.getRoot());
}

}
