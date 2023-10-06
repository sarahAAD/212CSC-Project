package Phonebook;

class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T val) {
		data = val;
		next = null;
	}
}

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
	}

    public boolean last(){
        if ( current==head)
            return true;
        return current.next==null;
    }

	public boolean full() {
		return false;
	}

	public void FindFirst() {
		current = head;
	}

	public void FindNext() {
		current = current.next;
	}


    public T retrieve(){
        if(head==null)
            return null;
        return current.data;
    }

	public void update(T val) {
		current.data = val;
	}

	/* public void add(T val) {
		Node<T> tmp=new Node<T>(val);
		if (empty()) {
			current = head = tmp;
		} else {
			if(((Contact)val).compareTo((Contact)head.data)<0) {
				tmp.next=head;
				head=tmp;
			}
			else {
			Node<T> s=head
			Node<T>	q=null;
			while(s!null&&(((Contact)s.data).compareTo((Contact)val)<=0)) {
				q=s;
				s=s.next;
			}
			q.next=tmp;
			tmp.next=s;
			}
		}
	} */

	public void delete() {
		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
	}

	public T search(T val) {
		Node<T> tmp = head;
		while (tmp.data != val) // or untill null? in case we use to search for duplicates or printing all
								// contacts with same first name
			tmp = tmp.next;
		return tmp.data;
	}

	public T search2(T val) {
		Node<T> tmp = head;
		while (tmp != null && tmp.data != val) // or should i use || instead of &&? for the same reasons listed above
			tmp = tmp.next;
		return tmp.data;
	}

	/*
	 * public void sort(){
	 * 
	 * // Node current will point to head current = head; Node<T> index = null; int
	 * tmp;
	 * 
	 * if (head == null) { return ; } else { while (current != null) { // Node index
	 * will point to node next to cuurent index = current.next;
	 * 
	 * while (index != null) { if (current.data > index.data) { tmp = current.data;
	 * current.data = index.data; index.data = tmp; }
	 * 
	 * index = index.next; } current = current.next; } } }
	 */

	public void display() {
		current = head;

		if (head == null)
			System.out.println("List is empty");

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();
	}

    public void remove(){
        if(current == head){
            head = head.next;
            current = current.next;
        }
        
        else{
            Node<T> p = head;
            while(p.next != current)
                p=p.next;
                p.next=current.next;
                if(current.next!=null)
                    current=current.next;
                else 
                    current=head;
            
        }
            
    }

    public void insert(T d){
        Node <T> p = new Node <T>(d);
        if ( head == null){
            head =p;
            current = p;
        }
        
        else {
            p.next = current.next;
            current.next=p;
            current =p;
        }
    }

	/*
	 * public boolean currentIsNull() { return current == null; }
	 */

	// for the sorting method we can use ascii of the letters?...
}
