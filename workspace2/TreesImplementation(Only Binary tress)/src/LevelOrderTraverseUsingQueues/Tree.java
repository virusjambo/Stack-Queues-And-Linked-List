package LevelOrderTraverseUsingQueues;

import java.util.LinkedList;
import java.util.Queue;



import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E> {
	Queue<Node<E>> queue =new LinkedList<Node<E>>();
	void levelOrderTranverse(Node<E> root){
		queue.add(root);
		int currentNodes=1;
		int nextNodes=0;
		
		while(!queue.isEmpty()){
			if(!(currentNodes==0)){
				Node<E> temp=queue.poll();
				System.out.print(temp.getValue());
				currentNodes--;
				nextNodes+=2;
				if(temp.getLeftRef()!=null)
				queue.add(temp.getLeftRef());
				if(temp.getRightRef()!=null)
				queue.add(temp.getRightRef());
			}else{
				System.out.println();
				currentNodes=nextNodes;
				nextNodes=0;
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		BinaryTree<Integer> bt=new BinaryTree<>();
		Integer[] arr={1,2,3,4,5,6,7,8,9,10};
		bt.covertToTree(arr);
		Tree<Integer> it=new Tree<>();
		it.levelOrderTranverse(bt.getRoot());
	}

}
