package queuesUsingarrays;

public class Queue<T> {
	int front,rear,size,capacity;
	T arr[];
	@SuppressWarnings("unchecked")
	public Queue(int capacity){
		this.arr=(T[]) new Object[capacity];
		front=size=0;
		rear=capacity;
		this.capacity=capacity;
		}

	void enqueue(T value){
	if(isFull()){
		return;
	}
		rear=(rear)%capacity;
		
		System.out.println( "front:"+front);
		arr[rear]=value;
		rear=rear+1%capacity;
		System.out.println( "rear:"+rear);
		size++;		
	}
	T dequeue(){
		if(isEmpty()){
			return null;
		}
	 T temp=arr[front];
		front=front+1%capacity;
		System.out.println( "front:"+front);
		size--;		
		return temp;
	}
	T rear(){
		return arr[rear];
	}
	T front(){
		return arr[front];
	}
	boolean isFull(){
		return size==capacity;
	}
	boolean isEmpty(){
		return size==0;
	}
	public static void main(String[] args) {
		 Queue<Integer> queue=new  Queue<>(4);
		 queue.enqueue(1);
		 queue.enqueue(2);
		 queue.enqueue(3);
		 queue.enqueue(4);
		System.out.println(queue.dequeue()); 
		System.out.println();
		System.out.println(queue.dequeue()); 
		System.out.println(queue.dequeue()); 
		System.out.println(queue.dequeue()); 
	}
	
}
