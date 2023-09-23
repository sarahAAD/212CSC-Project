package Phonebook;

public class Contact extends PhoneBook {
	  private String Name,PhoneNumber,Email,Address,Birthday,Notes;
	  private Event Event;


	    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes,Event event) {
	        Name = name;
	        PhoneNumber = phoneNumber;
	        Email = email;
	        Address = address;
	        Birthday = birthday;
	        Notes = notes;
	        Event.addEvent(event);
	    }

	    public Contact(Contact obj){
	         Name = obj.Name;
	         PhoneNumber=obj.PhoneNumber;
	         Email= obj.Email;
	         Address = obj.Address;
	         Birthday = obj.Birthday;
	         Notes=obj.Notes;
	         Event.addEvent(obj.Event);
	 
	 
	}
	    
	    
	        public void SearchByEmail(String email){
	        Contact ContactArray[] = new Contact[13]; // ContactLinkedList.length()
	        int size=0;
	        ContactLinkedList.FindFirst();
	        while(!ContactLinkedList.last()){
	            if (ContactLinkedList.retrieve().Email.equalsIgnoreCase(email))
	               ContactArray[size++] = ContactLinkedList.retrieve();
	            ContactLinkedList.FindNext();
	        }   if (ContactLinkedList.retrieve().Email.equalsIgnoreCase(email))
	               ContactArray[size++] = ContactLinkedList.retrieve();
	        
	        for ( int i =0; i < size; i++)
	            ContactArray[i].toString();
	        
	    }
	        
	        
	    public void SearchByAddress(String address){
	        Contact ContactArray[] = new Contact[13];
	        int size=0;
	        ContactLinkedList.FindFirst();
	        while(!ContactLinkedList.last()){
	            if (ContactLinkedList.retrieve().Address.equalsIgnoreCase(address))
	               ContactArray[size++] = ContactLinkedList.retrieve();
	            ContactLinkedList.FindNext();
	        }   if (ContactLinkedList.retrieve().Address.equalsIgnoreCase(address))
	               ContactArray[size++] = ContactLinkedList.retrieve();
	        
	        for ( int i =0; i < size; i++)
	            ContactArray[i].toString();
	        
	    }
	    
	    
	        public void SearchByBirthday(String birthday){
	        Contact ContactArray[] = new Contact[13];
	        int size=0;
	        ContactLinkedList.FindFirst();
	        String Day = birthday.substring(0, 2);
	        String month = birthday.substring(3, 5);
	        String year = birthday.substring(6, 10);
	        while(!ContactLinkedList.last()){
	            if (ContactLinkedList.retrieve().Birthday.substring(0, 2).equals(Day)&&ContactLinkedList.retrieve().Birthday.substring(3, 5).equals(month)&&ContactLinkedList.retrieve().Birthday.substring(6, 10).equals(year))
	               ContactArray[size++] = ContactLinkedList.retrieve();
	            ContactLinkedList.FindNext();
	        }   if (ContactLinkedList.retrieve().Birthday.substring(0, 2).equals(Day)&&ContactLinkedList.retrieve().Birthday.substring(3, 5).equals(month)&&ContactLinkedList.retrieve().Birthday.substring(6, 10).equals(year))
	               ContactArray[size++] = ContactLinkedList.retrieve();
	        
	        for ( int i =0; i < size; i++)
	            ContactArray[i].toString();
	        
	    }
	                
	                
	            @Override
	    public String toString() {
	        return "Contact{" + "name=" + Name + "/n PhoneNumber=" + PhoneNumber + "/n Email=" + Email + "/n Address=" + Address + "/n Birthday=" + Birthday + "/n notes=" + Notes + "/n event=" + Event + '}';
	    }

	    public String getName() {
	        return Name;
	    }

	    public void setName(String name) {
	        this.Name = name;
	    }

	    public String getPhoneNumber() {
	        return PhoneNumber;
	    }

	    public void setPhoneNumber(String PhoneNumber) {
	        this.PhoneNumber = PhoneNumber;
	    }

	    public String getEmail() {
	        return Email;
	    }

	    public void setEmail(String Email) {
	        this.Email = Email;
	    }

	    public String getAddress() {
	        return Address;
	    }

	    public void setAddress(String Address) {
	        this.Address = Address;
	    }

	    public String getBirthday() {
	        return Birthday;
	    }

	    public void setBirthday(String Birthday) {
	        this.Birthday = Birthday;
	    }

	    public String getNotes() {
	        return Notes;
	    }

	    public void setNotes(String notes) {
	        this.Notes = notes;
	    }

	    public Event getEvent() {
	        return Event;
	    }

	    public void setEvent(Event event) {
	        this.Event = event;
	    }


	    }

	   
	  


