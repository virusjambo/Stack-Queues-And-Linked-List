package findingAnextGreaterElement;

public class Stack<T extends Number> {
	int top;
	int capacity;
	T values[];
	
	
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
 void findNextGreaterElement(Stack<T> stack,T[] arr){
	T next;
	
	stack.push(arr[0]);
	for(int i=1;i<arr.length;i++){
		next=arr[i];
		while(!stack.isEmpty()&& stack.peak().doubleValue()<next.doubleValue()){
			if(stack.isEmpty())
				break;
		System.out.println(stack.pop().doubleValue()+ "   "+ next.doubleValue());	
		
		}
		stack.push(next);
		
	}
	while(!stack.isEmpty()){
		System.out.println(stack.pop().doubleValue()+ "   "+ -1);
		
	}
	
	
}
public static void main(String[] args) {
	Integer[] arr={1,2,3,4};
	Stack<Integer> st=new Stack<Integer>(arr.length-1);
	st.findNextGreaterElement(st,arr);
}
}
