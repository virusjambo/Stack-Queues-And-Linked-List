package RootToLeafPathSumEqualToaGivenNumber;


import java.util.ArrayDeque;


import createtreeusingagivearray.Node;

public class Tree<E extends Number> {
	
	@SuppressWarnings("unchecked")
	E [] value=(E[])new Number[100];
	int count=0;
	
	//Method 1 using a temp array which will store a tree node
	Node<E> root;
	public Node<E> getRoot() {
		return root;
	}
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	ArrayDeque<Node<E>> queue;
	
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
	boolean flag=false;
	boolean createTree(Node<E> root,int path,int sum){
		
		if(root==null)
			return false;
		value[path++]=root.getValue();
		if(root.getLeftRef()==null && root.getRightRef()==null){
			flag=flag||validateWithSum(path,sum);
		System.out.println("flag:" +flag);
		}
		
		else{
			createTree(root.getLeftRef(),path,sum);
			createTree(root.getRightRef(),path,sum);
			
		}
	return flag;	
	}
	
	boolean validateWithSum(int path,int total){
		int sum=0;
		for(int i=0;i<path;i++){
			System.out.print(value[i]);
			sum+=value[i].intValue();
			
		}
		System.out.println("SUM :"+sum);
		if(sum==total)
			return true;
		else
			return false;
		
	}
	
	//Method2 effective than first one substract a current node value from sum given .if zero sum exists.
	boolean findRootToLeafSumPropety(Node<E> root,int  sum){
		boolean flag=false;
		if(root==null){
			return sum==0;
			
		}
		sum= sum-root.getValue().intValue();
		if(sum==0&&root.getLeftRef()==null && root.getRightRef()==null){
			return true;
		}else{
			flag=flag||findRootToLeafSumPropety(root.getLeftRef(),sum)|| findRootToLeafSumPropety(root.getRightRef(),sum);
			
		}
		return flag;
		
	}
	
	public static void main(String[] args) {
		Tree<Integer> it=new Tree<>();
		Integer[] arr={1,2,3,4,5,6,7,8,9,10};
		it.covertToTree(arr);
	System.out.println(it.findRootToLeafSumPropety(it.getRoot(),0));	
	//	System.out.println(it.createTree(it.getRoot(), 0, 11));
	}
	
}
