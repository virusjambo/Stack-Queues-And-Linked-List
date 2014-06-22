package mergetwosortedlinkedlist;
class LinkedList<E extends Number> implements Cloneable {

    Node<E> head = null;
    Node<E> tail = null;

    // Adding at the End
    class Node<T extends Number> {

        T value;
        Node<T> nextReference;

        public Node(T value) {
            this.value = value;
            this.nextReference = null;
        }

        public Node(T value, Node<T> ref) {
            this.value = value;
            this.nextReference = ref;
        }

        public Node() {
            // TODO Auto-generated constructor stub
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextReference() {
            return nextReference;
        }

        public void setNextReference(Node<T> nextReference) {
            this.nextReference = nextReference;
        }
    }

    public void add(E value) {
        Node<E> l = tail;
        Node<E> node = new Node<E>(value);
        tail = node;
        if (head == null) {
            head = node;
        } else {
            l.setNextReference(node);
        }



    }

    public void add(Node<E> node) {

        if (validate(head)) {
            head = node;

        } else {
            tail.setNextReference(node);
        }


    }

    Node<E> mergeTwoSortedLinkedList(LinkedList<E> linkedList, LinkedList<E> linkedList1) {
        LinkedList<E> mergedList = new LinkedList<E>();
        Node<E> head1 = linkedList.head;//123 123345
        Node<E> head2 = linkedList1.head;
        while (head1 != null && head2 != null) {
            if (head1.getValue().doubleValue() <= head2.getValue().doubleValue()) {
                mergedList.add(head1.getValue());

                head1 = head1.getNextReference();
            } else {

                mergedList.add(head2.getValue());

                head2 = head2.getNextReference();
            }

        }
        if (head1 == null) {
            mergedList.add(head2);
        }
        if (head2 == null) {
            mergedList.add(head1);
        }
        return mergedList.head;

    }

  

    void printAll(Node<E> node) {

        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNextReference();
        }

    }

    Node<E> usingRecursive(Node<E> head, Node<E> head1) {
        Node<E> result = null;// 134 3456
        if (head == null) {
            return head1;
        }
        if (head1 == null) {
            return head;
        }
        if (head.getValue().doubleValue() <= head1.getValue().doubleValue()) { //true
            result = head;    //1 3 4

            result.nextReference = usingRecursive(head.getNextReference(), head1);

        } else {
            result = head1;

            result.nextReference = usingRecursive(head, head1.getNextReference());
        }
        return result;
    }

    Node<E> recursiveCall(LinkedList<E> linkedList, LinkedList<E> linkedList1) {
        return usingRecursive(linkedList.head, linkedList1.head);
    }

    public boolean validate(Node<E> head) {
        if (head == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("List1");
        linkedList.printAll(linkedList.head);
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);
        System.out.println("List2");
        linkedList1.printAll(linkedList1.head);
        linkedList.printAll(linkedList.mergeTwoSortedLinkedList(linkedList, linkedList1));
        linkedList.printAll(linkedList.recursiveCall(linkedList, linkedList1));

    }
}
