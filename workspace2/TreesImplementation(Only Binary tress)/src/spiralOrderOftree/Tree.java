package spiralOrderOftree;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;;

public class Tree<E> {
	
	public int getDepth(Node<E> root){
		if(root==null){
			return 0;
		}
		int l=getDepth(root.getLeftRef());
		int r=getDepth(root.getRightRef());
		if(l>r)
			return l+1;
		else
			return r+1;
	}
void	printAll(Node<E> root){
	boolean flag=false;
	for(int i=1;i<=getDepth(root);i++){
		printLevelsCircular(root,i,flag);
		flag=!flag;
		System.out.println();
	}
		
	}
void printLevelsCircular(Node<E> root,int path,boolean flag){
	if(root==null){
		return;
	}
	if(path==1){
		System.out.print(root.getValue());
		return;
	}
	if(!flag){
		printLevelsCircular(root.getLeftRef(),path-1,flag);
		printLevelsCircular(root.getRightRef(),path-1,flag);
	}else{
		printLevelsCircular(root.getRightRef(),path-1,flag);
		printLevelsCircular(root.getLeftRef(),path-1,flag);	
	}
	
}
	public static void main(String[] args) {
		BinaryTree<Integer> bt=new BinaryTree<>();
		Integer[] arr={1,2,3,4,5,6,7,8,9,10};
		bt.covertToTree(arr);
		Tree<Integer> it=new Tree<>();
		it.printAll(bt.getRoot());
	}
}
