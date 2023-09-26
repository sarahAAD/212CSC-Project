package Phonebook;

public class Event extends Contact {
	 private String eventTitle; 
	 private String DateAndTime;
	 private String location;
	 private Contact contact;
	 private LinkedListQueue  eventList;

	    public Event(String eventTitle, String DateAndTime, String location, Contact contact) {
	        super(contact);
	        this.eventTitle = eventTitle;
	        this.DateAndTime = DateAndTime;
	        this.location = location;
	        eventList = new LinkedListQueue();
	        
	    }
	    
	    public void addEvent(Event event){
	        ContactLinkedList.FindFirst();
	        while(!ContactLinkedList.last()){
	            if(ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName()) && ContactLinkedList.retrieve().getEvent().DateAndTime.equals(event.DateAndTime) )
	             eventList.enqueue(event);
	            else{
	                ContactLinkedList.FindNext();
	            }
	        }  
	        if(ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName()) && ContactLinkedList.retrieve().getEvent().DateAndTime.equals(event.DateAndTime))
	             eventList.enqueue(event);
	        else {
	            System.out.println("This contact doesn't exist, can't add the event");
	        }
	        }

	    
	    public Event SearchByTitle(String Title){
	        int size = eventList.length();
	        for(int i =0; i< size; i++){
	            Event temp = eventList.serve();
	            if (temp.eventTitle.equalsIgnoreCase(Title)){
	              eventList.enqueue(temp);
	              return temp;
	            }      
	        } 
	        System.out.println("This event doesn't exist");
	         return null;
	    }
	    
	    public Event SearchByContactName(String Name){
	        int size = eventList.length();
	        for(int i =0; i< size; i++){
	            Event temp = eventList.serve();
	            if (temp.contact.getName().equalsIgnoreCase(Name)){
	              eventList.enqueue(temp);
	              return temp;
	            }      
	        } 
	        System.out.println("This event doesn't exist");
	         return null;
	    }    
	 
	 
	}
