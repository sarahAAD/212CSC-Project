package Phonebook;

public class Event extends PhoneBook {
	private String eventTitle;
	private String DateAndTime;
	private String location;
	private Contact contact;
	private LinkedListQueue eventList;
	LinkedList<Contact> ContactList = new LinkedList<>();

	public Event() {
	}

	public Event(String eventTitle, String DateAndTime, String location, Contact c) {
		this.eventTitle = eventTitle;
		this.DateAndTime = DateAndTime;
		this.location = location;
		contact = new Contact(c);
		eventList = new LinkedListQueue();

	}

	public void addEvent(Event event) {
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getEvent() == null) {
					eventList.enqueue(event);
				} 
				else if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName())&& (!ContactLinkedList.retrieve().getEvent().DateAndTime.equals(event.DateAndTime)))
					eventList.enqueue(event);
				else
					ContactLinkedList.FindNext();
			}

			if (ContactLinkedList.retrieve().getEvent() == null) {
				eventList.enqueue(event);
			} 
			else if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(event.contact.getName())&& (!ContactLinkedList.retrieve().getEvent().DateAndTime.equals(event.DateAndTime)))
				eventList.enqueue(event);			

		}

	else System.out.println("This contact doesn't exist, can't add the event");

	}

	public Event SearchByTitle(String Title) {
		int size = eventList.length();
		for (int i = 1; i <= size; i++) {
			Event temp = eventList.serve();
			if (temp.eventTitle.equalsIgnoreCase(Title)) {
				eventList.enqueue(temp);
				return temp;
			}
		}
		System.out.println("This event doesn't exist");
		return null;
	}

	public Event SearchByContactName(String Name) {
		int size = eventList.length();
		for (int i = 1; i <= size; i++) {
			Event temp = eventList.serve();
			if (temp.contact.getName().equalsIgnoreCase(Name)) {
				eventList.enqueue(temp);
				return temp;
			}
		}
		System.out.println("This event doesn't exist");
		return null;
	}

	public void alphabrticOrder(String name) {
		LinkedListQueue events = new LinkedListQueue();
		Event tmp = eventList.serve();
		events.enqueue(tmp);
		for (int i = 0; i < eventList.length(); i++) {
			if (tmp.eventTitle.charAt(0) >= eventList.serve().eventTitle.charAt(0)) {

			}
		}

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

	public LinkedListQueue getEventList() {
		return eventList;
	}

	public void setEventList(LinkedListQueue eventList) {
		this.eventList = eventList;
	}

	public String toString() {
		return "eventTitle:" + eventTitle + "\nDateAndTime:" + DateAndTime + "\nlocation:" + location + "\ncontact:"
				+ contact + "\neventList:" + eventList + "\nContactList:" + ContactList;
	}

}
