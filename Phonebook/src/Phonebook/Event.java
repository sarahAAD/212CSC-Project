package Phonebook;

public class Event extends PhoneBook {
	private String eventTitle;
	private String DateAndTime;
	private String location;
	private Contact contact;
	private String ContactName;

	public Event() {
	}

	public Event(Event event) {
		eventTitle = event.eventTitle;
		DateAndTime = event.DateAndTime;
		location = event.location;
		contact = new Contact(event.contact);
		ContactName = event.ContactName;
	}

	public Event(String eventTitle, String DateAndTime, String location, Contact c, String contactName) {
		this.eventTitle = eventTitle;
		this.DateAndTime = DateAndTime;
		this.location = location;
		contact = new Contact(c);
		ContactName = contactName;
	}

	public int compareTo(Event event) {
		return eventTitle.compareTo(event.eventTitle);
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

	public String toString() {
		return "\nevent title:" + eventTitle + "\nDate and time:" + DateAndTime + "\nlocation:" + location
				+ "\ncontact name:" + contact.getName();
	}

	public String getContactName() {
		return ContactName;
	}

	public void setContactName(String contactName) {
		ContactName = contactName;
	}

}
