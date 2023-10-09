package Phonebook;

import java.util.Scanner;

public class PhoneBook {
	static LinkedList<Contact> ContactLinkedList = new LinkedList<>();
	static LinkedList<Event> eventList = new LinkedList<>();

	public static void main(String[] args) {
		PhoneBook PhoneBook = new PhoneBook();
		String choice = "0";
		System.out.println("Welcome to the Linked Tree Phonebook!");
		do {
			System.out.println("\nPlease choose an option:\r\n" + "1. Add a contact\r\n" + "2. Search for a contact\r\n"
					+ "3. Delete a contact\r\n" + "4. Schedule an event\r\n" + "5. Print event details\r\n"
					+ "6. Print contacts by first name\r\n" + "7. Print all events alphabetically\r\n" + "8. Exit");

			Scanner scan = new Scanner(System.in);

			System.out.print("Enter your choice:");
			choice = scan.nextLine();

			switch (choice) {
			case "1":
				Contact c1 = new Contact();
				System.out.print("Enter the contact's name:");
				String name = scan.nextLine();
				c1.setName(name);
				System.out.print("Enter the contact's phone number:");
				String number = scan.nextLine();
				c1.setPhoneNumber(number);
				System.out.print("Enter the contact's email address:");
				String email = scan.nextLine();
				c1.setEmail(email);
				System.out.print("Enter the contact's address:");
				String address = scan.nextLine();
				c1.setAddress(address);
				System.out.print("Enter the contact's birthday:");
				String birthday = scan.nextLine();
				c1.setBirthday(birthday);
				System.out.print("Enter any notes for the contact:");
				String notes = scan.nextLine();
				c1.setNotes(notes);
				if (PhoneBook.AddContact(c1))
					System.out.println("\nContact added successfully!");
				else
					System.out.println("\nThis Contact has been added before!");

				break;

			case "2": // search for a contact
				LinkedList<Contact> contacts = new LinkedList<>();
				Contact contact = new Contact();
				System.out.println(
						"Enter search criteria:\n1.Name\n2.Phone Number\n3.Email Address\n4.Address\n5.Birthday");
				String searchInput = scan.nextLine();

				switch (searchInput) { // nested switch
				case "1":
					System.out.print("Enter the contact's name:");
					String contactName = scan.nextLine();
					contact = PhoneBook.SearchByName(contactName);
					if (contact != null)
						System.out.println(contact.toString());
					else
						System.out.println("There is no contact with this name");
					break;

				case "2":
					System.out.print("Enter the contact's phone number:");
					String contactPhoneNumber = scan.nextLine();
					contact = PhoneBook.SearchByPhoneNumber(contactPhoneNumber);
					if (contact != null)
						System.out.println(contact.toString());

					else {
						System.out.println("There is no contact with this phone number");
					}

					break;

				case "3":
					System.out.print("Enter the contact's email address:");
					String contactEmailAddress = scan.nextLine();
					contacts = PhoneBook.SearchByEmail(contactEmailAddress);
					if (!contacts.empty()) {
						contacts.FindFirst();
						while (!contacts.last()) {
							System.out.println(contacts.retrieve());
							contacts.FindNext();
						}
						System.out.println(contacts.retrieve());
					} else
						System.out.println("There is no contact with this email");

					break;

				case "4":
					System.out.print("Enter the contact's address:");
					String contactAddress = scan.nextLine();
					contacts = PhoneBook.SearchByAddress(contactAddress);
					if (!contacts.empty()) {
						contacts.FindFirst();
						while (!contacts.last()) {
							System.out.println(contacts.retrieve());
							contacts.FindNext();
						}
						System.out.println(contacts.retrieve());
					} else
						System.out.println("There is no contact with this adderss");

					break;

				case "5":
					System.out.print("Enter the contact's birthday:");
					String contactBirthday = scan.nextLine();
					contacts = PhoneBook.SearchByBirthday(contactBirthday);
					if (!contacts.empty()) {
						contacts.FindFirst();
						while (!contacts.last()) {
							System.out.println(contacts.retrieve());
							contacts.FindNext();
						}
						System.out.println(contacts.retrieve());
					} else
						System.out.println("There is no contact with this birthday");

					break;
				}

				break;

			case "3": // delete contact
				System.out.println("Enter delete criteria:\n1.Name\n2.Phone Number\n3.Email Address");
				String deleteInput = scan.nextLine();

				switch (deleteInput) { // nested switch
				case "1":
					System.out.print("Enter contact name:");
					scan.next();
					String deleteName = scan.nextLine();
					if (PhoneBook.DeleteContactByName(deleteName))
						System.out.println("Contact deleted successfully");
					else
						System.out.println("Contact not found");
					break;

				case "2":
					System.out.print("Enter contact phone number:");
					String deletePhoneNumber = scan.nextLine();
					if (PhoneBook.DeleteContactByPhoneNumber(deletePhoneNumber))
						System.out.println("Contact deleted successfully");
					else
						System.out.println("Contact not found");
					break;

				case "3":
					System.out.print("Enter contact email address:");
					String deleteEmail = scan.nextLine();
					if (PhoneBook.DeleteContactByEmail(deleteEmail))
						System.out.println("Contact deleted successfully\n");
					else
						System.out.println("Contact not found");
					break;
				}
				break;

			case "4": // schedule an event
				System.out.print("Enter event title:");
				String eventTitle = scan.nextLine();
				System.out.print("Enter contact name:");
				String contactName = scan.nextLine();
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
				String eventTimeAndDate = scan.nextLine();
				System.out.print("Enter event location:");
				String eventLocation = scan.nextLine();
				Contact c = null;
				;
				if (PhoneBook.SearchByName(contactName) != null) {
					c = PhoneBook.SearchByName(contactName);
					Event e = new Event(eventTitle, eventTimeAndDate, eventLocation, c);
					PhoneBook.AddEvent(e);
					System.out.println("Event added successfully!");

				} else
					System.out.println("Contact doesn't exist, please add the contact first");

				break;

			case "5": // print event detail
				Event event = new Event();
				System.out.print("Enter search criteria:\n1.contact name\n2.event title\n");
				String eventInput = scan.nextLine();

				switch (eventInput) { // nested switch
				case "1":

					System.out.print("Enter contact name:");
					String eventContactName = scan.nextLine();
					event = PhoneBook.SearchEventByContactName(eventContactName);
					if (event != null)
						System.out.println(event.toString());
					else
						System.out.println("Event not found");

					break;

				case "2":
					System.out.print("Enter event title:");
					String EventTitle = scan.nextLine();
					event = PhoneBook.SearchEventByTitle(EventTitle);
					if (event != null)
						System.out.println(event.toString());
					else
						System.out.println("Event not found");
					break;
				}

				break;

			case "6": // print contacts by first name

				System.out.print("Enter the first name:");
				String firstName = scan.nextLine();
				PhoneBook.PrintSameFirstName(firstName);
				break;

			case "7":
				PhoneBook.printAllEvent();
				break;

			case "8":
				return;

			case "9": // just to check that the contacts are sorted correctly
				if (ContactLinkedList.empty())
					System.out.println("is empty");
				else {
					ContactLinkedList.FindFirst();
					while (!ContactLinkedList.last()) {
						System.out.println(ContactLinkedList.retrieve());
						ContactLinkedList.FindNext();
					}
					System.out.println(ContactLinkedList.retrieve());
				}
			}
		} while (choice != "8");

	}

	public boolean AddContact(Contact contact) {
		boolean found = false;
		if (ContactLinkedList.empty()) {
			ContactLinkedList.add(contact);
			return true;
		} else {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())
						|| ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
					found = true;
				}

				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())
					|| ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber())) {
				found = true;
			}
		}
		if (!found) {
			ContactLinkedList.add(contact);
			return true;
		} else
			return false;
	}

	public boolean AddEvent(Event event) {
		if (eventList.empty()) {
			eventList.insert(event);
			return true;
		} else {
			eventList.FindFirst();
			while (!eventList.last()) {
				if (!eventList.retrieve().isExist(event)
						&& !eventList.retrieve().getEventTitle().equals(event.getEventTitle())) {
					eventList.insert(event);
					return true;
				}

				eventList.FindNext();
			}
			if (!eventList.retrieve().isExist(event)
					&& !eventList.retrieve().getEventTitle().equals(event.getEventTitle())) {
				eventList.insert(event);
				return true;
			}
		}
		return false;
	}
	
	 /*public void AddEvent(Event e) {
			Event r =	SearchEventByTitle(e.getEventTitle());
			if(r==null) {
				eventList.addEvent(r);
			}
					
			
			
		}
*/
	public Event SearchEventByTitle(String title) {
		Event event = null;
		if (!eventList.empty()) {
			eventList.FindFirst();
			while (!eventList.last()) {
				if (eventList.retrieve().getEventTitle().equals(title))
					event = eventList.retrieve();

				eventList.FindNext();
			}
			if (eventList.retrieve().getEventTitle().equals(title))
				event = eventList.retrieve();
		}

		return event;
	}

	public Event SearchEventByContactName(String name) {
		Event event = null;
		if (!eventList.empty()) {
			eventList.FindFirst();
			while (!eventList.last()) {
				if (eventList.retrieve().getContact().getName().equals(name))
					event = eventList.retrieve();

				eventList.FindNext();
			}
			if (eventList.retrieve().getContact().getName().equals(name))
				event = eventList.retrieve();
		}

		return event;
	}

	public LinkedList<Contact> SearchByAddress(String address) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		if (ContactLinkedList.empty())
			return Contacts;

		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getAddress().equals(address))
				Contacts.insert(ContactLinkedList.retrieve());
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getAddress().equals(address))
			Contacts.insert(ContactLinkedList.retrieve());

		return Contacts;

	}

	public Contact SearchByName(String name) {
		Contact contact = null;
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
					contact = ContactLinkedList.retrieve();

				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
				contact = ContactLinkedList.retrieve();
		}

		return contact;
	}

	public Contact SearchByPhoneNumber(String PhoneNumber) {
		Contact contact = new Contact();
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
					contact = ContactLinkedList.retrieve();

				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
				contact = ContactLinkedList.retrieve();
		}

		return contact;
	}

	public LinkedList<Contact> SearchByBirthday(String birthday) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();

			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getBirthday().equals(birthday))
					Contacts.add(ContactLinkedList.retrieve());
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getBirthday().equals(birthday))
				Contacts.add(ContactLinkedList.retrieve());

			return Contacts;
		}
		return null;

	}

	public LinkedList<Contact> SearchByEmail(String email) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getEmail().equals(email))
					Contacts.insert(ContactLinkedList.retrieve());
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getEmail().equals(email))
				Contacts.insert(ContactLinkedList.retrieve());

			return Contacts;
		}
		return Contacts;

	}

	public void PrintSameEvent(String event) {
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getEventTitle().equalsIgnoreCase(event)) {
					System.out.println(ContactLinkedList.retrieve());
					ContactLinkedList.FindNext();
				} else
					ContactLinkedList.FindNext();

			}
			if (ContactLinkedList.retrieve().getEventTitle().equalsIgnoreCase(event))
				System.out.println(ContactLinkedList.retrieve());

		} else
			System.out.println("There is no event with this name");
	}

	public void PrintSameFirstName(String name) {
		String FirstName;
		int index;
		if (ContactLinkedList.empty())
			System.out.println("There is no contact with this name");
		else {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				index = ContactLinkedList.retrieve().getName().indexOf(" ");
				FirstName = ContactLinkedList.retrieve().getName().substring(0, index);
				if (FirstName.equals(name))
					System.out.println(ContactLinkedList.retrieve().toString());

				ContactLinkedList.FindNext();

			}
		}
		index = ContactLinkedList.retrieve().getName().indexOf(" ");
		FirstName = ContactLinkedList.retrieve().getName().substring(0, index);
		if (FirstName.equalsIgnoreCase(name))
			System.out.println(ContactLinkedList.retrieve().toString());

		else
			System.out.println("There is no contact with this name");

	}

	public boolean DeleteContactByName(String name) {
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name)) {
					deleteEvent(ContactLinkedList.retrieve().getName());
					ContactLinkedList.remove();

					return true;
				}
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
				deleteEvent(ContactLinkedList.retrieve().getName());
			ContactLinkedList.remove();

			return true;
		}

		return false;
	}

	public boolean DeleteContactByPhoneNumber(String phoneNumber) {
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
					deleteEvent(ContactLinkedList.retrieve().getName());
					ContactLinkedList.remove();

					return true;
				}
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(phoneNumber))
				deleteEvent(ContactLinkedList.retrieve().getName());
			ContactLinkedList.remove();

			return true;
		}

		return false;
	}

	public boolean DeleteContactByEmail(String Email) {
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getEmail().equalsIgnoreCase(Email)) {
					deleteEvent(ContactLinkedList.retrieve().getName());
					ContactLinkedList.remove();

					return true;
				}
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getEmail().equalsIgnoreCase(Email))
				deleteEvent(ContactLinkedList.retrieve().getName());
			ContactLinkedList.remove();

			return true;
		}

		return false;
	}

	public void printAllEvent() {
		if (eventList.empty()) {
			System.out.println("there is no event");
			return;
		}
		eventList.FindFirst();
		while (!eventList.last()) {
			System.out.println(eventList.retrieve());
			eventList.FindNext();
		}
		System.out.println(eventList.retrieve());

	}

	public void deleteEvent(String ContactName) {
		if (!eventList.empty()) {
			eventList.FindFirst();
			while (!eventList.last()) {
				if (eventList.retrieve().getContact().getName().equalsIgnoreCase(ContactName)) 
					eventList.remove();
				
				eventList.FindNext();
			}
			if (eventList.retrieve().getContact().getName().equalsIgnoreCase(ContactName)) 
				eventList.remove();

		}
		else return;

	}
	
}