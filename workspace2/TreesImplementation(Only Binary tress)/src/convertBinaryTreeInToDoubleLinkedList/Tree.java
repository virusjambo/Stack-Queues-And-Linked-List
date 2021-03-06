package convertBinaryTreeInToDoubleLinkedList;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree <E>{

	 Node<E> convertComplexMethod1(Node<E> root){
		 if(root==null)
			 return root;
		 if(root.getLeftRef()!=null){
			 Node<E> temp=convertComplexMethod1(root.getLeftRef());
			 for(;temp.getRightRef()!=null;temp=temp.getRightRef());
			 temp.setRightRef(root);
			 root.setLeftRef(temp);	 
		 }
		 if(root.getRightRef()!=null){
			 Node<E> temp=convertComplexMethod1(root.getRightRef());
			 for(;temp.getLeftRef()!=null;temp=temp.getLeftRef());
			 temp.setLeftRef(root);
			 root.setRightRef(temp);
		 }
		return root;
	}
	 
	 void printDLL(Node<E> newRoot){
		 Node<E> root=newRoot;
		 while(root.getLeftRef()!=null){
			 
			 root=root.getLeftRef();
			 
		 }
		 while(root!=null){
			 System.out.print(root.getValue());
			 root=root.getRightRef();
		 }
		 System.out.println();
		 
	 }
//Method 2 
	 Node<E> dllRoot=new Node<>();
	 Node<E> prev;
	void  convertComplexMethod2(Node<E> root){
		 if(root==null)
			 return ;
		 convertComplexMethod2(root.getLeftRef());
		 
		 if(prev==null){
			dllRoot=root;
			prev=root;
		 }
		 else{
			 prev.setRightRef(root);
			 root.setLeftRef(prev);
			 prev=root;
		 }
		 convertComplexMethod2(root.getRightRef());
	
	}
	 
		public static void main(String[] args) {
			BinaryTree<Integer> bt=new BinaryTree<>();
			Integer[] arr={1,2,3,4,5,6,7};
			BinaryTree<Integer> bt1=new BinaryTree<>();
			Integer[] arr1={1,2,3,4,5,6,7};
			bt.covertToTree(arr);
			bt1.covertToTree(arr1);
			Tree<Integer> it=new Tree<>();
			//Method 1
			System.out.println("Method1");
			Node<Integer> newRoot=it.convertComplexMethod1(bt.getRoot());
			it.printDLL(newRoot);
			System.out.println("Method2");
			it.convertComplexMethod2(bt1.getRoot());
			it.printDLL(it.dllRoot);
		} 
}
