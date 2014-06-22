package BoundryTraverseOfTree;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E> {
	void printLeftView(Node<E> root){
		if(root==null)
			return;
		if(root.getLeftRef()!=null){
			System.out.println(root.getValue());
			printLeftView(root.getLeftRef());
			
		}else if(root.getRightRef()!=null){
			System.out.println(root.getValue());
			printLeftView(root.getRightRef());	
		}
		
		
	}
	void printRightView(Node<E> root){
		if(root==null)
			return;
		if(root.getRightRef()!=null){
			System.out.println(root.getValue());
			printLeftView(root.getRightRef());
			
		}else if(root.getLeftRef()!=null){
			System.out.println(root.getValue());
			printLeftView(root.getLeftRef());	
		}
		
		
	}
	
	void printLeafs(Node<E> root){
		if(root==null)
			return;
		if(root.getLeftRef()==null && root.getRightRef()==null){
			System.out.println(root.getValue());
			return;
		}
		printLeafs(root.getLeftRef());
		printLeafs(root.getRightRef());
		
		
	}
	public static void main(String[] args) {
		BinaryTree<Integer> bt=new BinaryTree<>();
		Integer[] arr={30,5,10,2,3,10,11,12,23,45};
		bt.covertToTree(arr);
		Tree<Integer> it=new Tree<>();
		it.printLeftView(bt.getRoot().getLeftRef());
		it.printLeafs(bt.getRoot().getLeftRef());
		it.printLeafs(bt.getRoot().getRightRef());
		it.printRightView(bt.getRoot().getRightRef());
		
		//System.out.println(it.isSumPropertyMethod3(bt.getRoot(),0));;
	}
}
