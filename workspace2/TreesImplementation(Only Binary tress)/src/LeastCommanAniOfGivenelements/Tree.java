package LeastCommanAniOfGivenelements;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E>{
	
Node<E>	findLCA(Node<E> root,E key,E key1){
	if(root==null){
		return null;
	}	
	if(root.getValue().equals(key)|| root.getValue().equals(key1))
		return root;
	Node<E> ls=findLCA(root.getLeftRef(), key, key1);
	Node<E> rs=findLCA(root.getRightRef(), key, key1);
	if(ls!=null && rs!=null)
		return root;
	return ls!=null?ls:rs;
	
	
	}
public static void main(String[] args) {
	BinaryTree<Integer> bt=new BinaryTree<>();
	Integer[] arr={1,2,3,4,5,6,7,8,9,10};
	bt.covertToTree(arr);
	Tree<Integer> it=new Tree<>();
	System.out.println(it.findLCA(bt.getRoot(),4,5).getValue());
}

}
