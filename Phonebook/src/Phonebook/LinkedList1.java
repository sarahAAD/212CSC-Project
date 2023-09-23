package Phonebook;

public class LinkedList1 <T> {
	   private Node<T> head ;
	   private Node<T> current;

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
	    
	    
	}

