package Phonebook;

public class Event extends PhoneBook {
	private String eventTitle;
	private String DateAndTime;
	private String location;
	private Contact contact;
	//public LinkedList<Event> eventList;
	
	public Event(){
    };

	public Event(String eventTitle, String DateAndTime, String location, Contact c) {
		this.eventTitle = eventTitle;
		this.DateAndTime = DateAndTime;
		this.location = location;
		contact = new Contact(c);
	}



    public boolean isExist(Event event) {                                                            //practically made to answer the question of wether a contact has a certain event  or not
		if (ContactLinkedList.empty())
			return false;
		else {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getEvent() != null) {                                  //if the contact actually has any events
					if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName())
							&& (!ContactLinkedList.retrieve().getEvent().retrieve().DateAndTime.equals(event.DateAndTime)))
						return true;
				}
				ContactLinkedList.FindNext();
			}

		}
		if (ContactLinkedList.retrieve().getEvent() != null) 
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName())
					&& (!ContactLinkedList.retrieve().getEvent().retrieve().DateAndTime.equals(event.DateAndTime)))
				return true;


			return false;

	}

	public boolean Exists (Event event){
		if (eventList.empty())
		return false;
		else {
			if (eventList.retrieve() != null){
			eventList.FindFirst();
			while (!eventList.last()){
				if (eventList.retrieve() == null)
				return false;
				if (eventList.retrieve() != null && eventList.retrieve().getDateAndTime().equals(event.DateAndTime) && eventList.retrieve().getEventTitle().equals(event.eventTitle) && eventList.retrieve().getLocation().equals(event.location) )
				return true;
				eventList.FindNext();
			}}
			/*if (eventList.retrieve().getDateAndTime().equals(event.DateAndTime) && eventList.retrieve().getEventTitle().equals(event.eventTitle) && eventList.retrieve().getLocation().equals(event.location) && eventList.retrieve() != null)
				return true;
			}*/
				return false;	
		}
	};

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getDateAndTime() {
		return DateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		DateAndTime = dateAndTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public LinkedList<Event> getEventList() {
		return eventList;
	}

	public void setEventList(LinkedList<Event> eventList) {
		this.eventList = eventList;
	}

	public String toString() {
		return "\nevent title:" + eventTitle + "\nDate and time:" + DateAndTime + "\nlocation:" + location + "\ncontact name:"
				+ contact.getName() ;
	}
	
	

}
