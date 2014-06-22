package reverseAStack;

public class Stack <T>{
	
	int top;
	int capacity;
	T values[];
	
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity){
	this.values= (T[])new  Object[capacity]	;
	this.capacity=capacity;
	this.top=-1;
	}
	


void 	push(T value){
	if(!isFull())
	values[++top]=value;	
		
	}
T pop() {
	if(!isEmpty())
	return values[top--];
	else{
		return null;
	}
	
}
T peak(){
	if(!isEmpty())
		return values[top];
		else
			return null;	
}
boolean isFull(){
	if(top==capacity-1)
		return true;
	return false;
}
boolean isEmpty(){
	if(top==-1)
		return true;
	return false;
}

void reverse(Stack<T> stack){
	T value;
	if(stack==null)
		return;
//	value=findLast(stack);
	reverse(stack);
	
	
}

public static void main(String[] args) {
	Stack<Integer> stack=new Stack<>(20);
	
	stack.push( 1);
	stack.push( 1);
	stack.push( 1);
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	
	
}
	

}
