package Phonebook;

import java.util.Scanner;

public class PhoneBook {
	static LinkedList<Contact> ContactLinkedList = new LinkedList<>();
	static PhoneBook PhoneBook;

	public static void main(String[] args) {
		String choice = "0";
		while (choice != "8") { 
			System.out.println("Welcome to the Linked Tree Phonebook!\r\n" + "Please choose an option:\r\n"
					+ "1. Add a contact\r\n" + "2. Search for a contact\r\n" + "3. Delete a contact\r\n"
					+ "4. Schedule an event\r\n" + "5. Print event details\r\n" + "6. Print contacts by first name\r\n"
					+ "7. Print all events alphabetically\r\n" + "8. Exit");

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

			case "2": //search for a contact
				System.out.println(
						"Enter search criteria:\n1.Name\n2.Phone Number\n3.Email Address\n4.Address\n5.Birthday");
				String searchInput = scan.nextLine();

				switch (searchInput) { // nested switch
				case "1":
					System.out.print("Enter the contact's name:");
					String contactName = scan.nextLine();
					PhoneBook.SearchByName(contactName);
					break;

				case "2":
					System.out.print("Enter the contact's phone number:");
					String contactPhoneNumber = scan.nextLine();
					PhoneBook.SearchByPhoneNumber(contactPhoneNumber);
					break;

				case "3":
					System.out.print("Enter the contact's email address:");
					String contactEmailAddress = scan.nextLine();
					PhoneBook.SearchByEmail(contactEmailAddress);
					break;

				case "4":
					System.out.print("Enter the contact's address:");
					String contactAddress = scan.nextLine();
					PhoneBook.SearchByAddress(contactAddress);
					break;

				case "5":
					System.out.print("Enter the contact's birthday:");
					String contactBirthday = scan.nextLine();
					PhoneBook.SearchByBirthday(contactBirthday);
					break;
				}

				break;

			case "3": // delete contact
				System.out.println("Enter search criteria:\n1.Name\n2.Phone Number\n3.Email Address");
				String deleteInput = scan.nextLine();
				
				switch (deleteInput) { //nested switch
				case "1":
					System.out.print("Enter contact name:");
					String deleteName = scan.nextLine();	
					PhoneBook.DeleteContactByName(deleteName);
					break;
					
				case"2":
					System.out.print("Enter contact phone number:");
					String deletePhoneNumber = scan.nextLine();	
					PhoneBook.DeleteContactByPhoneNumber(deletePhoneNumber);
					break;
					
				case "3":
					System.out.print("Enter contact email address:");
					String deleteEmail = scan.nextLine();	
					PhoneBook.DeleteContactByEmail(deleteEmail);
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
				
				Contact c = PhoneBook.SearchByName(contactName).retrieve();

				Event e = new Event(eventTitle, eventTimeAndDate, eventLocation, c); 
				//eventList.enqueue(e);
				break;

			case "5": // print event detail
				System.out.print("Enter search criteria:\n1.contact name\n2.event title\n");
				String eventInput = scan.nextLine();

				switch (eventInput) { //nested switch
				case "1":
					System.out.print("Enter contact name:");
					String eventContactName = scan.nextLine();
					//PhoneBook.SearchByContactName(eventContactName);
					//eventList.SearchByContactName(eventContactName); //what am i supposed to do??
					break;

				case "2":
					System.out.print("Enter event title:");
					String eventTitlePrint = scan.nextLine();
					// search
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
		}

	}

	public boolean AddContact(Contact contact) {
		if (ContactLinkedList.empty())
			ContactLinkedList.add(contact);
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())
					&& ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()))
				return false;
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())
				&& ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()))
			return false;
		else {
			ContactLinkedList.add(contact);
			return true;
		}
	}

	public LinkedList<Contact> SearchByAddress(String address) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getAddress().equalsIgnoreCase(address))
				Contacts.add(ContactLinkedList.retrieve());
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getAddress().equalsIgnoreCase(address))
			Contacts.add(ContactLinkedList.retrieve());

		return Contacts;

	}
	
	public LinkedList<Contact> SearchByName(String name) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
				Contacts.add(ContactLinkedList.retrieve());
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name))
			Contacts.add(ContactLinkedList.retrieve());

		return Contacts;

	}
	
	public LinkedList<Contact> SearchByPhoneNumber(String PhoneNumber) {
		LinkedList<Contact> Contacts = new LinkedList<>();
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
				Contacts.add(ContactLinkedList.retrieve());
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(PhoneNumber))
			Contacts.add(ContactLinkedList.retrieve());

		return Contacts;

	}

	public LinkedList<Contact> SearchByBirthday(String birthday) {
		LinkedList<Contact> Contacts = new LinkedList<>();
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

	public LinkedList<Contact> SearchByEmail(String email) {
		LinkedList<Contact> Contacts = new LinkedList<>();

		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getEmail().equalsIgnoreCase(email))
				Contacts.add(ContactLinkedList.retrieve());
			ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getEmail().equalsIgnoreCase(email))
			Contacts.add(ContactLinkedList.retrieve());

		return Contacts;

	}

	public void PrintSameEvent(String event) {
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getEventList().retrieve().getEventTitle().equalsIgnoreCase(event)) {
				System.out.println(ContactLinkedList.retrieve());
				ContactLinkedList.FindNext();
			} else
				ContactLinkedList.FindNext();

		}
		if (ContactLinkedList.retrieve().getEventList().retrieve().getEventTitle().equalsIgnoreCase(event)) {
			System.out.println(ContactLinkedList.retrieve());
		}

	}

	public void PrintSameFirstName(String name) {
		ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name)) {
				System.out.println(ContactLinkedList.retrieve());
				ContactLinkedList.FindNext();
			} else
				ContactLinkedList.FindNext();

		}
		if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name)) {
			System.out.println(ContactLinkedList.retrieve());
		}

	}

	public boolean DeleteContactByName(String name) {
		if (ContactLinkedList.empty())
			return false;
		else
			ContactLinkedList.FindFirst();
		while (!ContactLinkedList.last()) {
			if (ContactLinkedList.retrieve().getName().equals(name)) {
				ContactLinkedList.delete();
				return true;
			} else
				ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getName().equals(name)) {
			ContactLinkedList.delete();
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
				ContactLinkedList.delete();
				return true;
			} else
				ContactLinkedList.FindNext();
		}
		if (ContactLinkedList.retrieve().getPhoneNumber().equals(phoneNumber)) {
			ContactLinkedList.delete();
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
