package morristranverseForInorder;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E> {
	
	void morrisTraverse(Node<E> root){
		Node<E>  current=root;
		Node<E> pre=null;
		while(current!=null){
			
			if(current.getLeftRef()==null){
				System.out.println(current.getValue());
				current=current.getRightRef();
				
			}else{
				pre=current.getLeftRef();
				while(pre.getRightRef()!=null && !pre.getRightRef().equals(current))
				pre=pre.getRightRef();
				if(pre.getRightRef()==null){
					pre.setRightRef(current);
					current=current.getLeftRef();
				}else{
					pre.setRightRef(null);
					System.out.println(current.getValue());
					current=current.getRightRef();
				}
			}
			
			
		}
		
		
	}
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<>();
		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
		bt.covertToTree(arr);
		Tree<Integer> it = new Tree<>();
		// System.out.println(it.maxWidthOfTree(bt.getRoot())); ;
		it.morrisTraverse(bt.getRoot());
		
	}
	
}
