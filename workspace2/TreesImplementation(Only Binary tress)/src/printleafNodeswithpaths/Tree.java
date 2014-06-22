package printleafNodeswithpaths;

import createtreeusingagivearray.Node;
import createtreeusingagivearray.BinaryTree;
public class Tree<E> {
E [] pathArr=(E[]) new Object[100]; 	

void findPathEachLeafNodes(Node<E> root,int path){
	if(root==null)
		return;
	pathArr[path++]=root.getValue();
	
	if(root.getLeftRef()==null && root.getRightRef()==null)
     printAll(pathArr,path);
	else{
		findPathEachLeafNodes(root.getLeftRef(),path);
		findPathEachLeafNodes(root.getRightRef(),path);
		
	}
}
void printAll(E [] pathArr, int path){
	for(int i=0;i<path;i++){
	System.out.print(pathArr[i]);	
		
	}
	System.out.println();
}
public static void main(String[] args) {
	BinaryTree<Integer> bt=new BinaryTree<>();
	Integer[] arr={1,2,3,4,5};
	bt.covertToTree(arr);
	Tree<Integer> it=new Tree<>();
	it.findPathEachLeafNodes(bt.getRoot(), 0);
}
}
