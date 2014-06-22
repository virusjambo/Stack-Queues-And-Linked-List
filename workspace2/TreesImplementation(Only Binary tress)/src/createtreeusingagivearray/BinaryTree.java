package createtreeusingagivearray;

import java.util.ArrayDeque;
/*Example Tree
 *     1
 //   /\
     2  3
    /\
   4  5
Example Tree
Depth First Traversals:
(a) Inorder
(b) Preorder
(c) Postorder


Inorder Traversal:

Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
Uses of Inorder
In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder itraversal s reversed, can be used.
Example: Inorder traversal for the above given figure is 4 2 5 1 3.

Preorder Traversal:

Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree)
Uses of Preorder
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree. Please see http://en.wikipedia.org/wiki/Polish_notation to know why prefix expressions are useful.
Example: Preorder traversal for the above given figure is 1 2 4 5 3.

Postorder Traversal:

Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
Uses of Postorder
Postorder traversal is used to delete the tree. Please see the question for deletion of tree for details. Postorder traversal is also useful to get the postfix expression of an expression tree. Please see http://en.wikipedia.org/wiki/Reverse_Polish_notation to for the usage of postfix expression.

Example: Postorder traversal for the above given figure is 4 5 2 3 1.*/

public class BinaryTree<E> {
	Node<E> root;
	public Node<E> getRoot() {
		return root;
	}
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	ArrayDeque<Node<E>> queue;
	int count=0;
	
	public void covertToTree(E arr[]){
		queue=new ArrayDeque<>();
    int i=1;
    root=new Node<E>(arr[0]);
    queue.addLast(root);
		while(i<=arr.length-1){
			Node<E> leftNode=new Node<E>(arr[i]);
			Node<E> right=null;
			++i;
			if(i<=arr.length-1){
				right=new Node<E>(arr[i]);;
			}
			++i;
			Node<E> parent=  queue.pollFirst();
			parent.setLeftRef(leftNode);
			parent.setRightRef(right);
			if(leftNode!=null)
			queue.addLast(leftNode);
			if(right!=null)
			queue.addLast(right);
			
		}
	
	}
void	printAll(Node<E> head){
	if(head==null)
		return;
	
	printAll(head.getLeftRef());//b//d //h
	printAll(head.getRightRef());//c//e //i
	System.out.println(head.getValue());
	
	
		
	}
boolean check(Node<E> head,Node<E> head1){
	if(head==null && head1==null){
		return true;
	}
	if(head!=null && head1!=null && head.getValue().equals(head1.getValue())){
		 return  check(head.leftRef,head1.leftRef) && check(head.rightRef,head1.rightRef);
	
		
	}
	return false;
	
}
 void totalNumberOfNodes(Node<E> head){
	 if(head==null)
		 return ;
	 ++count;
	 totalNumberOfNodes(head.leftRef);
	 totalNumberOfNodes(head.rightRef);
	 
	
}
 //Tranverse till end of tree in both ways.Once reached try to calculate length of tree by comparing left and right
 int finaMaxDepthOfTree(Node<E> head){
	 if(head==null){
		 return 0;
		 
	 }
	int l= finaMaxDepthOfTree(head.getLeftRef()); 
	int r= finaMaxDepthOfTree(head.getRightRef()); 
	if(l>r)
		 return l=l+1;
	else
		return r=r+1;
	 
 }
 //Delete a tree In java this is not necessary as garbage collector will handle memory allocation and deletion on its own.
 //This code is just a reference how other languages behave.
 //To delete a tree we have to delete first child's then parent.So we will go with  post order Traversal.
 void deleteTree(Node<E> root){
	if(root==null)
		return ;
	deleteTree(root.leftRef);
	 
	deleteTree(root.rightRef);
	root.setLeftRef(null);
	root.setRightRef(null);
	root.setValue(null);
 }

/* Write a Mirror tree .what is mirror tree.................
     1                                    1
    /\                                    /\
   2  3  mirror of this tree will be     3  2
   /\                                       /\
  4  5                                      5 4
  
  So after looking at both the tree we found out that we just need to swap the nodes at each level
 */
 
 void mirrorImageOfTree(Node<E> root){
		if(root==null)
			return ;
		mirrorImageOfTree(root.leftRef);
		mirrorImageOfTree(root.rightRef);
		Node<E> temp=root.leftRef;
		root.leftRef=root.rightRef;
		root.rightRef=temp;
		
		
	 }
public static void main(String[] args) {
	String[] st={"1","2","3","4","5"};
	String[] st1={"a","b","c","d","e","f","g","k","i","k"};
	BinaryTree<String> bin=new BinaryTree<>();
	BinaryTree<String> bin1=new BinaryTree<>();
	bin.covertToTree(st);
	bin1.covertToTree(st1);
	//bin.printAll(bin.root);
	//System.out.println("Second");
	//bin.printAll(bin1.root);
	//System.out.println("result");
	//System.out.println(bin.check(bin.root,bin1.root));;
	//bin.totalNumberOfNodes(bin.root);
	//System.out.println(bin.count);
	//Call to find max depth of tree
	//System.out.println(bin.finaMaxDepthOfTree(bin.root));
	//call to delete a tree
	//bin.deleteTree(bin.root);
	//bin.printAll(bin.root);
	bin.printAll(bin.root);
	bin.mirrorImageOfTree(bin.root);
	bin.printAll(bin.root);
}	

}
