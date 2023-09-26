package Phonebook;

public class PhoneBook {
    LinkedList<Contact> ContactLinkedList = new LinkedList<>();



  
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
  

