package Phonebook;

import java.util.Scanner;

public class PhoneBook {
	static LinkedList<Contact> ContactLinkedList = new LinkedList<>();

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
				System.out.println("\nContact added successfully!");
				PhoneBook.AddContact(c1);
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
					if (PhoneBook.SearchByName(contactName) != null)
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
							ContactLinkedList.FindNext();
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
							ContactLinkedList.FindNext();
						}
						System.out.println(contacts.retrieve());
					} else
						System.out.println("There is no contact with this adderss");

					break;

				case "5":
					System.out.print("Enter the contact's birthday:");
					String contactBirthday = scan.nextLine();
					if (!PhoneBook.SearchByBirthday(contactBirthday).empty()) {
						contacts.FindFirst();
						while (!contacts.last()) {
							System.out.println(contacts.retrieve());
							ContactLinkedList.FindNext();
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
				Contact c = new Contact(PhoneBook.SearchByName(contactName));
				Event e = new Event(eventTitle, eventTimeAndDate, eventLocation, c);
				e.addEvent(e);

				break;

			case "5": // print event detail
				Event event = new Event();
				System.out.print("Enter search criteria:\n1.contact name\n2.event title\n");
				String eventInput = scan.nextLine();

				switch (eventInput) { // nested switch
				case "1":
					System.out.print("Enter contact name:");
					String eventContactName = scan.nextLine();
					Contact contact1 = new Contact(PhoneBook.SearchByName(eventContactName));
					event = contact1.getEvent();
					if (event != null)
						System.out.println(contact1.getEvent().toString());
					else
						System.out.println("Event not found");
					break;

				case "2":
					System.out.print("Enter event title:");
					String EventTitle = scan.nextLine();
					event = PhoneBook.ContactLinkedList.retrieve().SearchByTitle(EventTitle);
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

			case "7": // print all events alphabetically
				break;

			case "8":
				return;

			}
		} while (choice != "8");

	}

	public boolean AddContact(Contact contact) {
		if (ContactLinkedList.empty())
			ContactLinkedList.insert(contact);
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())
					|| ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()))
				return false;
			else 
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())
				|| ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()))
			return false;
		else {
			ContactLinkedList.insert(contact);
			return true;
		}
	}

	public LinkedList<Contact> SearchByAddress(String address) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getAddress().equalsIgnoreCase(address))
					Contacts.add(ContactLinkedList.retrieve());
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getAddress().equalsIgnoreCase(address))
				Contacts.add(ContactLinkedList.retrieve());

			return Contacts;
		} else
			return null;

	}

	public Contact SearchByName(String name) {
		if (!ContactLinkedList.empty()) {
			Contact contact = new Contact();
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
					contact = ContactLinkedList.retrieve();
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
				contact = ContactLinkedList.retrieve();

			return contact;
		} else
			return null;

	}

	public Contact SearchByPhoneNumber(String PhoneNumber) {
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber)) {
					return ContactLinkedList.retrieve();

				}
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
				return ContactLinkedList.retrieve();
		}

		return null;
	}

	public LinkedList<Contact> SearchByBirthday(String birthday) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();

			while (!ContactLinkedList.last()) {
				if (ContactLinkedList.retrieve().getBirthday().equals(birthday))

					Contacts.insert(ContactLinkedList.retrieve());
				ContactLinkedList.FindNext();
			}
			if (ContactLinkedList.retrieve().getBirthday().equals(birthday))
				Contacts.insert(ContactLinkedList.retrieve());

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
			if (ContactLinkedList.retrieve().getEventTitle().equalsIgnoreCase(event)) {
				System.out.println(ContactLinkedList.retrieve());
			}

		} else
			System.out.println("There is no event with this name");
	}

	public void PrintSameFirstName(String name) {
		String FirstName = null;
		if (!ContactLinkedList.empty()) {
			ContactLinkedList.FindFirst();
			while (!ContactLinkedList.last()) {
				FirstName = ContactLinkedList.retrieve().getName().substring(0,
						ContactLinkedList.retrieve().getName().indexOf(' '));
				if (FirstName.equalsIgnoreCase(name)) {
					System.out.println(ContactLinkedList.retrieve().toString());
					ContactLinkedList.FindNext();
				} else
					ContactLinkedList.FindNext();

			}
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name)) {
				System.out.println(ContactLinkedList.retrieve());
			}
		} else
			System.out.println("There is no contact with this name");

	}

	public boolean DeleteContactByName(String name) {
		if (ContactLinkedList.empty())
			return false;
		else
			ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getName().equals(name)) {
				ContactLinkedList.remove();
				;
				return true;
			} else
				ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getName().equals(name)) {
			ContactLinkedList.remove();
			;
			return true;
		}

		return false;
	}

	public boolean DeleteContactByPhoneNumber(String phoneNumber) {
		if (ContactLinkedList.empty())
			return false;
		else
			ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getPhoneNumber().equals(phoneNumber)) {
				ContactLinkedList.remove();
				;
				return true;
			} else
				ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getPhoneNumber().equals(phoneNumber)) {
			ContactLinkedList.remove();
			;
			return true;
		}

		return false;
	}

	public boolean DeleteContactByEmail(String Email) {
		if (ContactLinkedList.empty())
			return false;
		else
			ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getEmail().equals(Email)) {
				ContactLinkedList.delete();
				return true;
			} else
				ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getEmail().equals(Email)) {
			ContactLinkedList.delete();
			return true;
		}

		return false;
	}

}
