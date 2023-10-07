package Phonebook;

public class Event extends PhoneBook {
	private String eventTitle;
	private String DateAndTime;
	private String location;
	private Contact contact;
	public LinkedList<Event> eventList = new LinkedList<>();
	LinkedList<Contact> ContactList = new LinkedList<>();

	public Event() {
	}

	public Event(String eventTitle, String DateAndTime, String location, Contact c) {
		this.eventTitle = eventTitle;
		this.DateAndTime = DateAndTime;
		this.location = location;
		contact = new Contact(c);

	}



	public boolean isExist(Event event) {
		if (ContactLinkedList.empty())
			return false;
		else {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getEvent() != null) {
					if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName())
							&& (!ContactLinkedList.retrieve().getEvent().DateAndTime.equals(event.DateAndTime)))
						return true;
				}
				ContactLinkedList.FindNext();
			}

		}
		if (ContactLinkedList.retrieve().getEvent() != null) 
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName())
					&& (!ContactLinkedList.retrieve().getEvent().DateAndTime.equals(event.DateAndTime)))
				return true;
		

			return false;

	}

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

	public LinkedList getEventList() {
		return eventList;
	}

	public void setEventList(LinkedList eventList) {
		this.eventList = eventList;
	}

	public String toString() {
		return "eventTitle:" + eventTitle + "\nDateAndTime:" + DateAndTime + "\nlocation:" + location + "\ncontact name:"
				+ contact.getName() ;
	}

}
