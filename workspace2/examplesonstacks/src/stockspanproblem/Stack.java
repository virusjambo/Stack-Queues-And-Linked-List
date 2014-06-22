package stockspanproblem;


public class Stack<T extends Number> {
	int top;
	int capacity;
	T values[];
	
	
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity){
	this.values= (T[])new  Number[capacity]	;
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
	 int result[]= new int[arr.length];
	 result[0]=1;
	 stack.push((T) new Integer(0));
	 for(int i=1;i<arr.length;i++){
		 while(!stack.isEmpty() && arr[stack.peak().intValue()].doubleValue() < arr[i].doubleValue()){
		 stack.pop();	 
		 }
		 result[i]= stack.isEmpty()?(i+1):(i-stack.peak().intValue());
		 stack.push((T)new Integer(i));
	 }
	 for(int i=0;i<result.length;i++){
		System.out.println(result[i]); 
	 } 
	 
	
}
public static void main(String[] args) {
	Integer[] arr={10, 4, 5, 90, 120, 80};
	Stack<Integer> st=new Stack<Integer>(arr.length-1);
	st.findNextGreaterElement(st,arr);
}
}