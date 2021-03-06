package TrucketTreeIfPathDoesNotMatchSum;

import createtreeusingagivearray.Node;

public class Tree<E extends Number> {
    
	Node<E> deleteTree(Node<E> root,double sum,double k){
		if(root==null){
			return null;
		}
		sum+=sum+root.getValue().doubleValue();
	root.setLeftRef(deleteTree(root.getLeftRef(),sum,k));
	root.setRightRef(deleteTree(root.getRightRef(),sum,k));
	if(sum<k && (root.getLeftRef()==null && root.getRightRef()==null)){
		root=null;
	}
		return root;
	}
	
	
	

}
