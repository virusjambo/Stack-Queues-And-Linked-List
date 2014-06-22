package TernerySeachTree;

import java.nio.CharBuffer;

public class TerneryTree<E,T> {

	public class Node<T>{
		Node<T> low;
		Node<T> high;
		Node<T> equal;
		char value;
		boolean isEnd;
		
		Node (){
			
		}
		Node(char value){
			this.low=null;
			this.high=null;
			this.equal=null;
			this.value=value;
			this.isEnd=false;
		}
		
		
	}
	
	 Node<T> insert(Node<T> root,int index,char [] arr){
		 if(root==null)
			 root=new Node<T>(arr[index]);
			 
			 if(root.value>arr[index])
				 root.low=insert(root.low,index,arr);
			 else if(root.value<arr[index])
				 root.high=insert(root.high,index,arr);
			 else{
				 if(index+1<arr.length)
				 root.equal=insert(root.equal,index+1,arr);
				 else
					root.isEnd=true; 
			 }
				 
					 
		 
		
		 return root;
	}
	
	 char charBuffer[]=new char[100];
	void traverse(Node<T> root,int index){
		if(root==null)
			return;
		traverse(root.low,index);
		charBuffer[index]=root.value;
		if(root.isEnd){
		printAll(index);	
		}
		traverse(root.equal,index+1);
		traverse(root.high,index);
		 
	 }
void	printAll(int index){
for(int i=0;i<=index;i++){
	System.out.println(charBuffer[i]);
}		
	}

boolean search(Node<T> root,int index,char []str){
	if(root==null)
		return false;
if(root.value>str[index])
	return search(root.low,index,str);
else if(root.value<str[index])
	return search(root.high,index,str);	
else
	if(root.isEnd && str.length-1==index)
		return true;
	else if (str.length-1==index)
		return false;
	else
		return search(root.equal,index+1,str);	
	
}
	
	public static void main(String[] args) {
		TerneryTree<String, Character> tr=new TerneryTree<>();
		String s1="Vikrant";
		String s2="Bharat";
		TerneryTree.Node root=tr.new Node<>();
		root=tr.insert(null, 0, s1.toCharArray());
		root=tr.insert(root, 0, s2.toCharArray());
		tr.traverse(root,0);
		//System.out.println(tr.traverse(root,0));
		System.out.println(tr.search(root, 0, "Vikrant".toCharArray()));;
	}
}
