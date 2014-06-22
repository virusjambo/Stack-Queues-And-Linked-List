package queuesUsingLinkedLIst;



public class Queue<T> {
Node<T> front;
Node<T> rear;

void enqueue(T value){
	if(rear==null){
		front=rear=new Node<T>(value);
		return;
	}
	Node<T> temp=	new Node<T>(value);
	rear.setNextRef(temp);
	rear=temp;
}

T dequeue(){
	if(front==null){
		rear=null;
		System.out.println("Queue is Empty");
		System.exit(0);
	}
	T value=front.getValue();
	 front=	front.getNextRef();

	return value;
}

public static void main(String[] args) {
	Queue<Integer> queue=new  Queue<>();
	 queue.enqueue(1);
	 queue.enqueue(2);
	 queue.enqueue(3);
	 queue.enqueue(4);
	System.out.println(queue.dequeue()); 
	System.out.println(queue.dequeue()); 
	System.out.println(queue.dequeue()); 
	System.out.println(queue.dequeue()); 
	System.out.println(queue.dequeue()); 
}
}

