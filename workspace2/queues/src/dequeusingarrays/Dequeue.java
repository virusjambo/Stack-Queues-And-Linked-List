package dequeusingarrays;

public class Dequeue<T> {
	int head;
	int tail;
	T []elements;
static final int MIN_LENGHT=8;
@SuppressWarnings("unchecked")
public Dequeue(){
	elements=(T[])new Object[16];
}

public Dequeue(int size){
assignSpace(size);
}
public boolean isEmpty() {
    return head == tail;
}

public T peekFirst() {
    return elements[head]; // elements[head] is null if deque empty
}

public T peekLast() {
    return elements[(tail - 1) & (elements.length - 1)];
}

@SuppressWarnings("unchecked")
void assignSpace(int size){
	int initCapcity=MIN_LENGHT;
	//TO find a next power of 2 which can make our data to fit proper.
	if(size>=initCapcity){
		initCapcity|=(initCapcity>>>1);
		initCapcity|=(initCapcity>>>2);
		initCapcity|=(initCapcity>>>4);
		initCapcity|=(initCapcity>>>8);
		initCapcity|=(initCapcity>>>16);
		initCapcity++;
		
	}
	elements=(T[])new Object[initCapcity];
	
}
void doubleCapacity(){
	int p=head;
	int len=elements.length;
	int r=len-head;//for the elements on right side
	Object[] a=new Object[len*2];
	//now copy the array
	//here we are swaping left side of array and right side of array
	System.arraycopy(elements, p, a, 0, r);
	System.arraycopy(elements, 0, a, r, p);
	elements=(T[])a;
	head=0;//logic is interesting see during add operation
	tail=len;
}
//here we are adding from 0th position of array
public void addLast(T value){
	elements[tail]=value;
	//once added check for head and tail collapse
	//This will be useful if you keep adding the elements at last without adding any elements at the first
	//then once it reaches last condition we should guarantee that over flow will happen
	//tail=8 head=0 element.lenght=7
	//in binary 1000&0111=0000	
	if((tail=tail+1 & elements.length-1)==head){
		doubleCapacity();
	}
	
}
//This will add from last position of array
public void addFirst(T value){
	//at first time head=-1 and suppose elements.length-1 is 7
	// then 1111&& 0111 leads to 0111 which is 7 and adds element at last.
	elements[head=head-1&elements.length-1]=value;
	if(head==tail){
		doubleCapacity();
	}
	
}
//Now remove first we will write it as pollFirst
public T pollFirst(){
		//which order you added same order in same order we should remove elements.
		T value=elements[head];
		if(value==null)
			return null;
		head=head+1&elements.length-1;//this is for flow from last element to first element
		return value;
		
	}
public T pollLast(){
	T value=elements[tail=tail-1&elements.length-1];
	//already tail will be one place ahead.This condition will help
	//to move from first element to last element of array in case your 
	//removing all elements from queue using this
	//method only
	return value;
}

public static void main(String[] args) {
	Dequeue<String> dq=new Dequeue<>(4);
	dq.addFirst("First1");
	dq.addFirst("First2");
	dq.addFirst("First3");
	dq.addFirst("First4");
	dq.addLast("Last1");
	dq.addLast("Last2");
	dq.addLast("Last3");
	dq.addLast("Last4");
	dq.addLast("Last5");
	dq.addLast("Last6");
	System.out.println(dq.pollFirst());
	System.out.println(dq.pollLast());;
	
	
}
//debug and find more Happy debugging
}
