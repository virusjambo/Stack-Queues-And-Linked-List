package treeSunPropertyInBinaryTree;


import createtreeusingagivearray.BinaryTree;
import createtreeusingagivearray.Node;

public class Tree<E extends Number> {
	//what is this
	//    30
	//    /\
	//   5  10
	//   /\  /\
	//  2  3 4 6
// method 1	
int sumPropertyTree(Node<E> root){
   if(root==null)
	   return 0;
  
  return root.getValue().intValue()+  sumPropertyTree(root.getLeftRef())+
		  sumPropertyTree(root.getRightRef());
   
   
 
}
boolean isSumProperty(Node<E> root){
	if(root==null || (root.getLeftRef()==null && root.getRightRef()==null))
		return true;
int l=sumPropertyTree(root.getLeftRef());
int r=sumPropertyTree(root.getRightRef());
return root.getValue().intValue()==l+r && isSumProperty(root.getLeftRef()) && isSumProperty(root.getRightRef());
}

//method 2 O(n complexity) 
boolean isSumPropertyMethod2(Node<E> root){
	int l = 0,r=0;
	if(root==null || isLeafNode(root))
		return true;
	if(root.getLeftRef() !=null  ){
		if(isLeafNode(root.getLeftRef()))
		l=root.getLeftRef().getValue().intValue();
	  else
		l=2*root.getLeftRef().getValue().intValue();
	}
	if(root.getRightRef()!=null){
	if(isLeafNode(root.getRightRef()))
		r=root.getRightRef().getValue().intValue();
	else
		r=2*root.getRightRef().getValue().intValue();
	}
	System.out.println(root.getValue().intValue() +"sum"+l+r );
return root.getValue().intValue()==l+r && isSumPropertyMethod2(root.getLeftRef()) && isSumPropertyMethod2(root.getRightRef());
	
}
boolean isLeafNode(Node<E> root){
	if(root == null || (root.getLeftRef()==null && root.getRightRef()==null))
		return true;
	return false;
}

// method 3 which is more effective and simple//this thing is cannot be achieved in java .Need to give try
boolean isSumPropertyMethod3(Node<E> root,int sum){
	if(root==null){
		sum=0;
	return true;
	}
	if(isLeafNode(root)){
		sum=root.getValue().intValue();
		System.out.println(sum);
		return true;
	}
	
	 int l=0,r=0;
	if(isSumPropertyMethod3(root.getLeftRef(),l) && isSumPropertyMethod3(root.getRightRef(),r) && root.getValue().intValue()==l+r) {
		sum =root.getValue().intValue()+l+r;
		System.out.println("l:"+l +"r:"+r+"sum:"+sum);
		return true;
	}
	return false;
}

	public static void main(String[] args) {
		BinaryTree<Integer> bt=new BinaryTree<>();
		Integer[] arr={30,5,10,2,3,10};
		bt.covertToTree(arr);
		Tree<Integer> it=new Tree<>();
		System.out.println(it.isSumPropertyMethod3(bt.getRoot(),0));;
	}

}
