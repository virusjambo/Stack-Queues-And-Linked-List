package DiameterofBinaryTree;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E> {
	//width of binary is the max number  of nodes  in a level .
	//Method 1 :Using Recursive way
	//for screwed binary tree worst case O(n2). 
	
int	findMaxWidth(Node<E> root){
		int height=findHeight(root);
		int MAX=0;
		int temp=0;
	for(int i=1;i<=height;i++)
		temp=findNumberOfNodesEachLevel(root,i);
	if(temp>MAX)
		MAX=temp;
	return MAX;
	}


int findNumberOfNodesEachLevel(Node<E> root,int level){
	if(root==null)
		return 0;
	if(level==1)
		return 1;
	return (findNumberOfNodesEachLevel(root.getLeftRef(),level-1)+ 
			findNumberOfNodesEachLevel(root.getRightRef(),level-1));
}
	int findHeight(Node<E> root){
		if(root==null)
			return 0;
		int l=findHeight(root.getLeftRef());
		int r=findHeight(root.getRightRef());
		if(l>r)
			return l+1;
		else
			 return r+1;
		
		
	}
	
	//Method 2 using temp array which will hold node count at each level
	
	public static void main(String[] args) {
		BinaryTree<Integer> bt=new BinaryTree<>();
		Integer[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		bt.covertToTree(arr);
		Tree<Integer> it=new Tree<>();
		System.out.println(it.findMaxWidth(bt.getRoot()));
	}
	

}
