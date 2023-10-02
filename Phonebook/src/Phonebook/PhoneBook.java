package Phonebook;
import java.util.Scanner;
public class PhoneBook {
    LinkedList<Contact> ContactLinkedList = new LinkedList<>();
    public static void main (String[]args){
        String choice="0";
        while(choice!="8"){ //loop is not working :-D wouldnt stop at 8 :-D
        System.out.println("Welcome to the Linked Tree Phonebook!\r\n" + 
                "Please choose an option:\r\n" + 
                "1. Add a contact\r\n" + 
                "2. Search for a contact\r\n" + 
                "3. Delete a contact\r\n" + 
                "4. Schedule an event\r\n" + 
                "5. Print event details\r\n" + 
                "6. Print contacts by first name\r\n" + 
                "7. Print all events alphabetically\r\n" + 
                "8. Exit");

                Scanner scan = new Scanner(System.in);

                System.out.print("Enter your choice:");
                choice = scan.nextLine();

                switch (choice){
                    case "1":
                    //create new object contact and link each attribute scanned ie obj.name =name;
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

                    break;

                    case "2":
                    System.out.println("Enter search criteria:\n1.Name\n2.Phone Number\n3.Email Address\n4.Address\n5.Birthday");
                    String input = scan.nextLine();

                    switch (input){ //nested switch
                        case "1":
                        System.out.print("Enter the contact's name:");
                        String contactName = scan.nextLine();
                        /*search by name method will be used here
                         * if(contactLinkedList.searchbyname) ??????????? idk
                         */
                        break;

                        case "2":
                        System.out.print("Enter the contact's phone number:");
                        String contactPhoneNumber = scan.nextLine();
                        //search
                        break;

                        case "3":
                        System.out.print("Enter the contact's email address:");
                        String contactEmailAddress = scan.nextLine();
                        //search
                        break;

                        case "4":
                        System.out.print("Enter the contact's address:");
                        String contactAddress = scan.nextLine();
                        //search
                        break;

                        case "5":
                        System.out.print("Enter the contact's birthday:");
                        String contactBirthday = scan.nextLine();
                        //search
                        break;
                    }

                    break;

                    case "3": //delete contact
                    break;

                    case "4": //schedule an event
                    System.out.print("Enter event title:");
                    String eventTitle = scan.nextLine();
                    System.out.print("Enter contact name:");
                    String contactName = scan.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
                    String eventTimeAndDate = scan.nextLine();
                    System.out.print("Enter event location:");
                    String eventLocation = scan.nextLine();

                    //maybe i should search for contact by name here first then add it in the method,

                    //Event e = new Event(eventTitle, eventTimeAndDate, eventLocation, c1); //how should i enter contact name?
                        
                    break;

                    case "5": //print event detail
                    System.out.print("Enter search criteria:\n1.contact name\n2.event title\n");
                    String eventInput = scan.nextLine();

                    switch(eventInput){
                        case "1":
                        System.out.print("Enter contact name:");
                        String eventContactName = scan.nextLine();
                        // eventList.SearchByContactName(eventContactName); //what am i supposed to do??
                        break;

                        case "2":
                        System.out.print("Enter event title:");
                        String eventTitlePrint = scan.nextLine();
                        //search
                        break;
                    }

                    break;

                    case "6": //print contacts by first name

                    System.out.print("Enter the first name:");
                    String firstName = scan.nextLine();
                    //what method to use?
                    break;

                    case "7": //print all events alphabetically
                    break;

                    case "8":
                    return;


                }
            }



    }
  
    public boolean AddContact(Contact contact){
        if(ContactLinkedList.empty())
            ContactLinkedList.insert(contact);
        ContactLinkedList.FindFirst();
        while(!ContactLinkedList.last()){
            if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())&&ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()) )
                return false;
            ContactLinkedList.FindNext();
        } if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(contact.getName())&&ContactLinkedList.retrieve().getPhoneNumber().equals(contact.getPhoneNumber()) )
             return false;
        else {
          ContactLinkedList.insert(contact);
          return true;}
    }
    
    public void SearchByAddress(String address){
        Contact ContactArray[] = new Contact[13]; // we should use ContactLinkedList length instead of 13 or print the contact immediately
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
    
    public void PrintSameEvent(String event) {
  	ContactLinkedList.FindFirst();
  	while(!ContactLinkedList.last()) {
  		if (ContactLinkedList.retrieve().getEvent().getName().equalsIgnoreCase(event)){
                  System.out.println(ContactLinkedList.retrieve());
                  ContactLinkedList.FindNext();
              }
              else ContactLinkedList.FindNext();
              
      } 
  		if (ContactLinkedList.retrieve().getEvent().getName().equalsIgnoreCase(event)){
                  System.out.println(ContactLinkedList.retrieve());
                  ContactLinkedList.FindNext();  }      
      
  }
    
    public void PrintSameFirstName(String name) {
ContactLinkedList.FindFirst();
while(!ContactLinkedList.last()) {
	if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name)){
            System.out.println(ContactLinkedList.retrieve());
            ContactLinkedList.FindNext();
        }
        else ContactLinkedList.FindNext();
        
} 
	if (ContactLinkedList.retrieve().getName().equalsIgnoreCase(name)){
            System.out.println(ContactLinkedList.retrieve());
            ContactLinkedList.FindNext();  }      

} 
    
    
}
  

