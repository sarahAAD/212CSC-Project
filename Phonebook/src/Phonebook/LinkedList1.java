package Phonebook;

class Node1 <T> { //new

    public T data;
    public Node1 <T> next;

    public Node1 () {
        data = null;
        next = null;
    }

    public Node1(T Data) {
        data = Data;
        next = null;
    }
 
}

public class LinkedList1 <T> {
	   private Node1<T> head ;
	   private Node1<T> current;

	    public LinkedList1() {
	        head = current =null;
	    }
	   
	    public boolean empty(){
	        return (head == null);
	    }
	    
	    
	    public boolean last(){
	        if ( current==head)
	            return true;
	        return current.next==null;
	    }
	    
	    public void FindFirst(){
	        current = head;
	    }
	    
	    public void FindNext(){
	        current = current.next;
	    }
	    
	    public void update(T d){
	        current.data=d;
	    }
	    
	    public T retrieve(){
	        if(head==null)
	            return null;
	        return current.data;
	    }
	    
	    public void insert(T d){
	        Node1 <T> p = new Node1 <T>(d);
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
	    
	    public void remove(){
	        if(current == head){
	            head = head.next;
	            current = current.next;
	        }
	        
	        else{
	            Node1<T> p = head;
	            while(p.next != current)
	                p=p.next;
	                p.next=current.next;
	                if(current.next!=null)
	                    current=current.next;
	                else 
	                    current=head;
	            
	        }
	            
	    }
	    
	    
	}

