package Phonebook;

public class LinkedListQueue {
    private Node<Event> Head;
    private Node<Event> Tail;
    private int size;
    
    public LinkedListQueue(){
        Head=Tail=null;
    }
    
    public boolean Full(){
        return false;
    }
    
    public int length(){
        return size;
    }
    
    public void enqueue(Event event ){
        Node <Event> p = new Node<Event>(event);
        if (Head == null)
            Head=Tail=p;
        else{
            Tail.next=p;
            Tail=Tail.next;
        }
        size++;
    }
    
    public Event servr(){
        Event node=Head.data;
        Head = Head.next;
        if(Head==null)
            Tail=null;
        size--;
        return node;
        }
    }


